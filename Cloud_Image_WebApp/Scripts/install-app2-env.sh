#!/bin/bash

runuser -l ubuntu -c 'git clone git@github.com:illinoistech-itm/knaik3.git'
runuser -l ubuntu -c 'sudo mv knaik3/ITMO-544/mp3/Code/Process/* /var/www/html/'
runuser -l ubuntu -c 'crontab -l > cronphp'
# referred this article http://tech.saigonist.com/b/server/how-run-cronjob-every-x-seconds-cron
runuser -l ubuntu -c 'echo "* * * * * /usr/bin/php -f /var/www/html/process.php; /usr/bin/php -f /var/www/html/index.php;" >> cronphp'
runuser -l ubuntu -c 'echo "* * * * * sleep 30; /usr/bin/php -f /var/www/html/process.php; /usr/bin/php -f /var/www/html/index.php;" >> cronphp'
runuser -l ubuntu -c 'crontab cronphp'

# runuser -l ubuntu -c 'echo "* * * * * sleep 45; /usr/bin/php -f /var/www/html/process.php" >> cronphp'
# runuser -l ubuntu -c 'echo "* * * * * sleep 30; /usr/bin/php -f /var/www/html/process.php" >> cronphp'
# runuser -l ubuntu -c 'echo "* * * * * sleep 15; /usr/bin/php -f /var/www/html/process.php" >> cronphp'
