#PA LAB 8
Compulsory{
    
    1. Baza de date a fost creata in Oracle Sqldev 
    2. Userul si parola au fost creati din Oracle SqlPlus
    3. Tabelele sunt create in metoda main, folosind standardul Oracle, pre Oracle12g+
    4. 
        - jdbc:oracle:thin:@localhost:1521:xe
        - acesta este url-ul, dar poate diferit 
        - a fost folosit jarul ojdbc8;
        - a fost introdus in maven cu mvn install:install-file -Dfile=path/to/your/ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=19.3 -Dpackaging=jar
        - a fost pus in pom asa:
            <dependency>
              <groupId>com.oracle</groupId>
              <artifactId>ojdbc8</artifactId>
              <version>19.3</version>
            </dependency>
            
    5. Creat si folosit si la temele de la sgbd, preluat de la https://gist.github.com/jasoet/3843797
    6. A fost creata clasa care executal scriptul sql cu parametrii dati. Atunci cand gaseste artisti cu numele cautati instantiaza cate un obiect de clasa Artist care corespunde tuplei din tabel
    7. Similar cu 6. Se returneaza tot o lista de Albume, pot fi mai multi artisti cu acelasi nume si mai multe albume de acelasi artist
    8. In metoda main sunt introdusi artisti si albume si sunt cautate si returnate

}

Optional {

    1. Nu a fost facut
    2. Clasa Album si Artist sunt modele orientate obiect ale unui rand din tabelele artists si albums
    3. Pentru a fi folosite date random, in fisierul pom.xml au fost adaugate:
        <dependency>
          <groupId>com.github.javafaker</groupId>
          <artifactId>javafaker</artifactId>
          <version>1.0.2</version>
        </dependency>
        -si au fost introduse in tabel nume random in acest mod:
        new Faker().name().fullName(), new Faker().nation().nationality()
    4. Nu a fost facut. 
    
    
    Structura bazei de date si functionalitatea ei a fost aratata la Compulsory.
    Intrucat nu a fost facut tot optionalul deci nu s-au adaugat tabele noi si structura bazei de date e aceeasi,
    nu am mai facut video.
}