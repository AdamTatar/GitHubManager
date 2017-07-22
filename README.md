# GitHubManager
repo tymczasowe do moich tasków, aż ogarniemy glowne repo projektu

// 3 dependencje od jGit - a, nie ma wszystkich potrzebnych metod, ale te które ma są całkiem przyjemne, na razie wykorzystane tylko do klonowania repo


<!-- https://mvnrepository.com/artifact/org.eclipse.jgit/org.eclipse.jgit -->
		<dependency>
			<groupId>org.eclipse.jgit</groupId>
			<artifactId>org.eclipse.jgit</artifactId>
			<version>4.5.0.201609210915-r</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>1.7.5</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-simple</artifactId>
			<version>1.6.4</version>
		</dependency>

// 2 dependencje do pobierania info o pull requestach z API githuba, wykorzystane do pobrania listy pull requestow.
API githuba daje sporo fajnych informacji o pull requescie jak login osoby, ktora zrobila pulla, czas itd, moza pozniej tez jakos wykorzystac

<!-- https://mvnrepository.com/artifact/org.json/json -->
		<dependency>
			<groupId>org.json</groupId>
			<artifactId>json</artifactId>
			<version>20090211</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.4</version>
		</dependency>
