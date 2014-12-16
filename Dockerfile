FROM williamyeh/scala

ADD . /app
WORKDIR /app


RUN sbt compile