CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

if ! test -f */ListExamples.java; then
 	echo "ListExamples.java does not exist"
	echo "Grade: 0"
	exit
fi

cp student-submission/ListExamples.java grading-area

cp TestListExamples.java grading-area

cp -r lib grading-area
cd grading-area
#javac -cp $CPATH grading-area/*.java
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java

exitValue=$?

if [ $exitValue != 0 ]; then
	echo "Compilation failed, exited with:" $exitValue
	echo "Grade: 0"
	exit $exitValue
fi

echo "compilation successful"

#java -cp $CPATH org.junit.runner.JUnitCore grading-area/TestListExamples
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples

exitValue=$?

if [ $exitValue != 0 ]; then
        echo "Error, exited with:" $exitValue
	echo "Grade: 50"
	exit $exitValue
fi

echo "Test completed successfully"
echo "Grade: 100"

rm -rf student-submission
rm -rf grading-area
