DIR_NAME=$(shell basename $(CURDIR))

JAR_PATH=target/$(DIR_NAME)-1.0-SNAPSHOT.jar
MAIN_CLASS_PATH=ru.rylenko.Main

$(JAR_PATH):
	@mvn clean package

run: $(JAR_PATH)
	@java -cp $(JAR_PATH) $(MAIN_CLASS_PATH) $(ARGS)

clean:
	@rm -rf target
