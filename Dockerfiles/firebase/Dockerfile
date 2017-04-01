#
# gdm firebase Docker Image
# --------------------------
# This file describes the standard way to build the firebase Docker image for gdm Project
#
# HOW TO BUILD THIS IMAGE
# -----------------------
# Run:
#      $ docker build -t gdm/firebase .
#
# HOW TO RUN THIS IMAGE
# -----------------------
# Run:
#      $ docker run --name node gdm/firebase
#
# Pull base image
# ----------
FROM gdm/node

# Maintainer
# ----------
MAINTAINER Jonthan Hernández Zapata <jhernandezz.dev@gmail.com>

# Labels
# ----------
LABEL version="1.0.0"
LABEL description="This file describes the standard way to build the firebase Docker image for gdm Project!"

# Install Dependencies
# ----------
RUN npm i -g firebase-tools
