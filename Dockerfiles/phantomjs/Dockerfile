#
# Kyani PhantomJS Docker Image
# --------------------------
# This file describes the standard way to build the PhantomJS Docker image for Kyani Project
#
# HOW TO BUILD THIS IMAGE
# -----------------------
# Run:
#      $ docker build -t kyani/phantomjs .
#
# HOW TO RUN THIS IMAGE
# -----------------------
# Run:
#      $ docker run --name node kyani/phantomjs
#
# Pull base image
# ----------
FROM kyani/webpack

# Maintainer
# ----------
MAINTAINER Andrés Amado <aamadoc@psl.com.co>

# Labels
# ----------
LABEL version="1.0.0"
LABEL description="This file describes the standard way to build the PhantomJS Docker image for Kyani Project!"

# Install Dependencies
# ----------
RUN apk update && \
    apk upgrade && \
    apk add --no-cache --update-cache ca-certificates curl tar && \
    curl -Ls https://github.com/fgrehm/docker-phantomjs2/releases/download/v2.0.0-20150722/dockerized-phantomjs.tar.gz | tar xz -C / && \
    apk del curl tar ca-certificates && \
    rm -rf /var/cache/apk/*
