#
# Kyani Electron Builder Docker Image
# --------------------------
# This file describes the standard way to build the Electron Builder Docker image for Kyani Project
#
# HOW TO BUILD THIS IMAGE
# -----------------------
# Run:
#      $ docker build -t kyani/electron-builder .
#
# HOW TO RUN THIS IMAGE
# -----------------------
# Run:
#      $ docker run --name node kyani/electron-builder
#
# Pull base image
# ----------
FROM electronuserland/electron-builder:wine

# Maintainer
# ----------
MAINTAINER Andrés Amado <aamadoc@psl.com.co>

# Labels
# ----------
LABEL version="1.0.0"
LABEL description="This file describes the standard way to build the Electron Builder Docker image for Kyani Project!"

# ENV variables
# ----------
ENV NODE_ENV=development \
    LANG=en_US.UTF-8 \
    CHARSET=UTF-8 \
    TIMEZONE=America/Bogota \
    TZ=America/Bogota

ENV PYTHON_VERSION=2.7.13

ENV DATA=/opt/kyani
ENV NODE_MODULES=${DATA}/node_modules
ENV WEB_NODE_MODULES=${DATA}/web/node_modules

# Install Dependencies
# ----------
RUN dpkg --add-architecture i386 && \
    apt-get update -y && \
    apt-get install -y --no-install-recommends ca-certificates build-essential checkinstall \
      gcc-multilib g++-multilib libreadline6 wine32 libreadline-gplv2-dev libncursesw5-dev \
      libssl-dev libsqlite3-dev tk-dev libgdbm-dev libc6-dev libbz2-dev && \
    cd /tmp && \
    wget --no-check-certificate https://www.python.org/ftp/python/${PYTHON_VERSION}/Python-${PYTHON_VERSION}.tgz && \
    tar -xzf Python-${PYTHON_VERSION}.tgz && cd Python-${PYTHON_VERSION} && ./configure && make && make install && cd .. && \
    rm -rf Python-${PYTHON_VERSION} && rm -f Python-${PYTHON_VERSION}.tgz && \
    cp /usr/share/zoneinfo/${TIMEZONE} /etc/localtime && echo "${TIMEZONE}" > /etc/timezone && \
    npm install -g typings typescript tslint webpack karma-cli rimraf && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Mount Volumes
# ----------
VOLUME $DATA
VOLUME $NODE_MODULES
VOLUME $WEB_NODE_MODULES

# Set Working Directory
# ----------
WORKDIR $DATA
