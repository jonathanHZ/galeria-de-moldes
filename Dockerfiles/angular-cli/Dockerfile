#
# gdm angular-cli Docker Image
# --------------------------
# This file describes the standard way to build the angular-cli Docker image for gdm Project
#
# HOW TO BUILD THIS IMAGE
# -----------------------
# Run:
#      $ docker build -t gdm/angular-cli .
#
# HOW TO RUN THIS IMAGE
# -----------------------
# Run:
#      $ docker run --name node gdm/angular-cli
#
# Pull base image
# ----------
FROM gdm/angular-cli

# Maintainer
# ----------
MAINTAINER Andrés Amado <aamadoc@psl.com.co>

# Labels
# ----------
LABEL version="1.0.0"
LABEL description="This file describes the standard way to build the angular-cli Docker image for gdm Project!"

# Install Dependencies
# ----------
RUN npm i -g @angular/cli
