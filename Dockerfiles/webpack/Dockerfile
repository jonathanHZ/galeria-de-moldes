#
# Kyani Webpack Docker Image
# --------------------------
# This file describes the standard way to build the Webpack Docker image for Kyani Project
#
# HOW TO BUILD THIS IMAGE
# -----------------------
# Run:
#      $ docker build -t kyani/webpack .
#
# HOW TO RUN THIS IMAGE
# -----------------------
# Run:
#      $ docker run --name node kyani/webpack
#
# Pull base image
# ----------
FROM kyani/node

# Maintainer
# ----------
MAINTAINER Andrés Amado <aamadoc@psl.com.co>

# Labels
# ----------
LABEL version="1.0.0"
LABEL description="This file describes the standard way to build the Electron Builder Docker image for Kyani Project!"

# ENV variables
# ----------
ENV DATA=/gdm
ENV NODE_MODULES=${DATA}/node_modules

# Install Dependencies
# ----------
RUN apk update && \
    apk upgrade && \
    apk add --no-cache --update-cache ca-certificates && \
    npm install -g typings typescript tslint webpack karma-cli rimraf && \
	  apk del ca-certificates && \
    rm -rf /var/cache/apk/*

# Mount Volumes
# ----------
VOLUME $DATA
VOLUME $NODE_MODULES

# Set Working Directory
# ----------
WORKDIR $DATA
