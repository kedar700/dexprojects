wlog = LOAD 'pig/log/small.txt' USING PigStorage(',') AS (idlog, date1, date2, URL, method); 
pday1 = GROUP wlog by (date2,URL);
pday2= FOREACH pday1 GENERATE group,COUNT(wlog) AS num;
pday3= GROUP pday2 by group.date2;
pdaymax = FOREACH pday3 {
SA = ORDER pday2 BY num DESC;
SB = LIMIT SA 1;
GENERATE FLATTEN(SB.group);}
DUMP pdaymax;

 
