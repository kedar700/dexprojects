#!/bin/bash

runuser -l ubuntu -c 'git clone git@github.com:illinoistech-itm/knaik3.git'
runuser -l ubuntu -c 'sudo mv knaik3/ITMO-544/mp3/Code/Instance/* /var/www/html/'
