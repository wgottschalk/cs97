BUILD = javac cscie97/asn1/knowledge/engine/*.java cscie97/asn1/test/*.java

test:
	$(BUILD)
	java -cp . cscie97.asn1.test.TestDriver inputTriples.nt inputQueries.nt

test-bad:
	$(BUILD)
	java -cp . cscie97.asn1.test.TestDriver badInputTriples.nt badInputQueries.nt

test-missing: 
	$(BUILD)
	java -cp . cscie97.asn1.test.TestDriver missingInputTriples.nt missingInputQueries.nt

clean:
	find . -type f -path "./*/*" -name "*.class" -exec rm -f {} \;
