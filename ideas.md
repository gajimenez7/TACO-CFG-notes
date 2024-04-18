# ideas

- using threads, run taco to multiple threads to make process more efficient
- if thread takes too long, slice problem and insert to end of queue
- things to split queue, inserts compilation unit to process
- n threads to compute, no more than n processes
- 1 extra thread to process things in the queue to split problems/ slicing
- document/ log of load of all processes (timeouts, splitting/slicing, unsat, sat)
- abort at sat or keep computing and keep log of all sat
- summary report
- queue for analysis/translation and queue for processing problems -> each with their own threads/ thread respectfully
- show tasks
