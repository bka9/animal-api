require 'pacto'
WebMock.allow_net_connect!
Pacto.configure do |c|
  c.contracts_path = 'contracts'
end
WebMock.allow_net_connect!

# Once we call `Pacto.generate!`, Pacto will record contracts for all requests it detects.
Pacto.generate!

require 'faraday'
conn = Faraday.new(url: 'http://localhost:3000')
response = conn.get '/'

puts response.body

conn.get '/animals'