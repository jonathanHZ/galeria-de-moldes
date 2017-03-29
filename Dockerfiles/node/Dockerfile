#
# Kyani Node Docker Image
# --------------------------
# This file describes the standard way to build the Node Docker image for Kyani Project
#
# HOW TO BUILD THIS IMAGE
# -----------------------
# Run:
#      $ docker build -t kyani/node .
#
# HOW TO RUN THIS IMAGE
# -----------------------
# Run:
#      $ docker run --name node kyani/node
#
# Pull base image
# ----------
FROM mhart/alpine-node:7.7.4

# Maintainer
# ----------
MAINTAINER Andrés Amado <aamadoc@psl.com.co>

# Labels
# ----------
LABEL version="1.0.0"
LABEL description="This file describes the standard way to build the Node Docker image for Kyani Project!"

# ENV variables
# ----------
ENV NODE_ENV=development \
    LANG=en_US.UTF-8 \
    CHARSET=UTF-8 \
    TIMEZONE=America/Bogota \
    TZ=America/Bogota

# Install Dependencies
# ----------
RUN apk update && \
    apk upgrade && \
    apk add --no-cache --update-cache bash tzdata ca-certificates git curl tar && \
    cp /usr/share/zoneinfo/${TIMEZONE} /etc/localtime && echo "${TIMEZONE}" > /etc/timezone && \
    npm cache clean && \
    curl -L https://npmjs.org/install.sh | sh && \
    apk del curl tar tzdata ca-certificates && \
    rm -rf /var/cache/apk/*
