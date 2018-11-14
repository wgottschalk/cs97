build:
	javac -cp . cscie97/asn2/housemate/model/*.java cscie97/asn2/test/*.java

run:
	java -cp . cscie97.asn2.test.TestDriver ./cscie97/asn2/test/test-commands.txt

clean:
	find . -type f -name "*.class" -delete

asn3:
	javac -cp . \
		cscie97/asn3/housemate/controller/*.java cscie97/asn3/test/*.java \
		cscie97/asn2/housemate/model/*.java \
		cscie97/asn1/knowledge/engine/*.java


asn3-test:
	java -cp . cscie97.asn3.test.TestRunner ./cscie97/asn3/test/test-commands.txt

asn3-test-two:
	java -cp . cscie97.asn3.test.TestRunner ./cscie97/asn3/test/test-beer-command.txt
