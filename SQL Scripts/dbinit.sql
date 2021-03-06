DROP DATABASE IF EXISTS kainos; 

CREATE DATABASE kainos; 
USE kainos; 

CREATE TABLE employee (employee_id int(6)  AUTO_INCREMENT, first_name VARCHAR(20) NOT NULL, last_name VARCHAR(20) NOT NULL, address_1 VARCHAR(50) NOT NULL,
address_2 VARCHAR(30), city VARCHAR(30) NOT NULL, postcode VARCHAR(8) NOT NULL, national_insurance VARCHAR(9) NOT NULL, bank_account VARCHAR(34) NOT NULL,
salary decimal(11,2) NOT NULL, PRIMARY KEY(employee_id));
 
CREATE TABLE bu (bu_id int(6) AUTO_INCREMENT, name VARCHAR(30) NOT NULL, directorid int(6) NOT NULL,PRIMARY KEY(bu_id),
FOREIGN KEY (directorid) REFERENCES employee(employee_id));

CREATE TABLE emp_bu(emp_id int(6), bu_id int(6) NOT NULL, PRIMARY KEY(emp_id), FOREIGN KEY (emp_id) REFERENCES employee(employee_id),
FOREIGN KEY (bu_id) REFERENCES bu(bu_id));

CREATE TABLE sales(sales_id int(6) NOT NULL, commission_rate decimal(5,4) NOT NULL, total_sales int(5) NOT NULL, FOREIGN KEY (sales_id) REFERENCES employee(employee_id));


INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Malaki","Woodward","1545 44th","Ann Arbor","48140","OOAN7SZ56","3554290154108162",481192);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Madyson","Henry","9978 sherwin","Peoria","61534","UQWGEROUM","4094693952282235",453129);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Neil","Emerson","1389 weed","Aurora","80028","NUXAIV7JE","6709257335231392",476533);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Frances","Read","5486 121st","Clarksville","37053","LURVNB8XO","36576993935482",50013);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Kole","Sampson","7455 lawler","Allentown","18158","2JTWOQ7CA","4917897156790480",610908);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jamison","Burris","4999 burling","Pittsburgh","15539","G81KCEPSX","6011017087171805",799734);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Lilyanna","Downs","8996 122nd","Charleston","29404","L7QVGBEHS","347976761489957",319842);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Chase","Ford","4661 superior","Tulsa","74342","QUQZZ7XAL","6473579726959446",100409);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Beau","Wilkerson","8641 merrill","Baltimore","21847","OBDWPU0TU","6374539611709777",703227);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Madelynn","Gonzales","9516 eisenhower ob kennedy ob","Honolulu","96702","9D8FFTBWU","5138866471664340",367700);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Leia","Logan","5592 15th","Raleigh","27145","CL04EIJ95","346920909906465",589154);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Joey","Riley","2630 keota","Thornton","80223","KRVEIKKK2","36268447592115",327622);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Carolyn","Allison","5377 new england","Sioux Falls","57079","VXZK5TBZ1","4602371667850969",405173);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jessie","Rivera","59 grover","New York","10960","YW293DID8","6762166152635128",143264);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Frank","Patel","8221 122nd","Little Rock","72115","PNDN0QEYB","5431425099920883",592223);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Darius","Warner","1078 kennedy wilson av","Evansville","47795","P22ATKYLE","341823393317329",956207);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Ryan","Bauer","2425 st mary","Arlington","76325","05YTYF9Z1","5466894724792157",299650);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Marquis","Franks","8750 s branch chicago river","San Jose","95082","JQKMTONMS","6709186815594252",189468);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Damari","Hooper","9172 redfield","Independence","64066","QYUWQ7R3X","3551968467979329",378617);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Elliana","Hunt","7401 fifth","Elizabeth","07257","6RS1AFU3J","6373779647452106",104293);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Catalina","Branch","2657 canfield","Overland Park","66236","QNVLVZHLM","378795132894832",910427);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Rylee","Tanner","4064 jackson","Colorado Springs","80953","VENA9XZ4R","5384080547752243",926762);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Levi","Le","2813 kildare","Bellevue","98065","2DJYAF0QJ","3572568886868932",447879);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Louis","Macias","6529 st georges","Hartford","06187","T8BT080O4","372726393997366",432604);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Lilyana","Stevens","9353 miami","New Orleans","70484","BV6V6F7TM","36752481315368",52682);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Bentley","Gamble","8147 pine","Salt Lake City","84058","OK3P352YX","5399572809543479",152682);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Ryland","Shelton","6279 independence","Fresno","93812","HWMWYTEZY","4232494674521130",482325);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Crosby","Odonnell","6390 31st","Fort Lauderdale","33468","OWF3SBB31","5142645714935798",106315);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Amaya","Harper","3641 markham","Charleston","29403","1B750TMHH","30445450759569",772988);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Theodore","Barr","4953 corliss","Springfield","01152","LQEWL8SDV","375001625728949",399960);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Barrett","Briggs","627 potawatomie","Peoria","61507","C6VUMX2Y0","6390464805344762",627354);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Tatiana","Short","1678 dawson","Milwaukee","53823","895HNYROB","3535496607296025",420052);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Cameron","Richard","6514 keeler","Chattanooga","37445","9V6FUWNFE","5893435756993413",657187);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jayson","Joyner","7099 railroad","Salt Lake City","84039","CD1TXBVMW","4479093356564111",866357);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jaylon","Garrison","771 edens wilson av","Irving","75078","MKOSBN5W3","4568807831762798",140867);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Tate","Nieves","5333 kennedy keeler av","Rochester","14628","T9KSWUUY3","6599844079640806",345340);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Ali","Mccoy","1521 dean","Independence","64031","ZQQ2QH150","4844821012581592",889459);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Miguel","Johnson","4599 dauphin","Aurora","80008","JQH1O3T66","347681156854290",371629);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Abigail","Robbins","4942 lister","Stockton","95206","A5JUS2T02","3561472148478163",534360);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Paisley","Gibbs","9508 vanderpoel","Fontana","92312","824TBSHJ0","6709490712956709",897095);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Sariah","Perry","6223 private","Fayetteville","72756","8GVOLDIM6","5135231809046053",184967);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Mike","Fischer","623 shakespeare","Eugene","97400","113SM3M9C","6380611431039354",567438);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Alexandria","Schwartz","7791 conservatory","Providence","02887","8LDM0THVY","30336085503706",495456);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jolie","Stafford","8824 103rd","Sioux Falls","57020","YE70KBQGM","5450394742942734",973267);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jase","Atkinson","3606 mann","Nashville","37196","1QTKAE4VB","4298390488996784",111803);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Alexander","Small","8793 la salle","Santa Ana","92681","91W2J4U3J","30105952733815",848692);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Kailee","Palmer","5512 buckingham","Irving","75081","ZLP472O5Q","30272400199484",571107);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Kira","Knox","5020 riverdale","Colorado Springs","80516","G5BL3YCXD","4913532113723134",447518);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Sarahi","Kemp","811 latrobe","San Antonio","78737","3WPAG2XFR","6709733123622471",333522);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Sam","Rosa","8640 kostner","San Antonio","78204","IQYLR26UV","6389200882724713",377667);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Briana","Pennington","4479 121st","Modesto","95330","NZZ0Z5BVU","377876611017300",690411);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Ronnie","Wolf","6412 corcoran","Elizabeth","07228","T4GX0NXII","30386483109622",980852);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Amya","Knowles","2503 eisenhower racine av","Charleston","29402","8D6EIEIKV","6771892335695767",757425);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Kyndall","Burch","6352 medill","Lansing","48837","V6DHGE520","6759036243669912",439425);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Francis","Hendrix","7547 115th","Irving","75004","606WY3IJ2","36583755263087",51940);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Kane","Burch","3457 ozanam","Yonkers","10725","96M99DVWC","5514273617032959",792360);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Xander","Swanson","2118 wacker nb lsd lower","Amarillo","79133","S2YS3VZPV","30076539954994",929811);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jesus","Riddle","5155 nottingham","Oxnard","93095","YNYCRMM38","370653300000807",878448);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Maeve","Huff","1491 111th","Laredo","78031","S2HPM1EE4","6391047386875228",260703);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Isaac","Berg","5417 dan ryan ob stevenson ib","Philadelphia","19702","89GL83WNE","6762850945709163",747815);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Camden","Harrell","5251 stevenson ib lsd sb","Rockford","61104","PJD5GOEH4","5492903259588670",565752);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Hayden","Beach","9187 bishop ford i57","Hartford","06128","V19WY8UXR","5294795392053392",734045);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jaydan","Bruce","4583 perry","Elizabeth","07221","ZSZWFN25U","4844663359809917",362306);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Meghan","Jarvis","8836 markham","Washington","20434","LHX58MDCV","6381538008106929",803561);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Ariella","Witt","3196 madison st","Fort Wayne","46900","H61S5PXKW","6441426170934021",781552);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jason","Stephenson","5155 brainard","Kansas City","66756","WWYRIXNA0","5215312213062986",131981);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Sarahi","Boyer","1331 kimbark","Springfield","01127","CR71H1KSI","342610856488427",866606);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Hanna","Griffith","579 seminole","Arlington","76371","ED9T4TOI9","349988223347432",922227);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Johan","Spears","9683 monon","Charleston","29402","9N55YOPHO","6393044560202525",140872);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Khalil","Walton","1618 maria","Joliet","60492","7LA2UYLZH","5020593861673860",313960);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Sullivan","Floyd","5586 jasper","Cedar Rapids","52226","2EFO02DEQ","5411325464053043",644098);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Amalia","Serrano","5274 138th","Los Angeles","90090","GY5JJP2HJ","4142237312011959",152026);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Gwyneth","Mccullough","9798 governors","Syracuse","13296","DHO6ST3YP","3538203027716690",582580);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Aniya","Gutierrez","6081 dr martin luther king jr","Rockford","61168","BY6ZE5BG9","6557857161769440",570940);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Amari","Noble","3627 south shore","Naperville","60429","YC2MKCF6V","3588701206154806",683491);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Elijah","Peck","5756 stevenson ib dan ryan","Charleston","29408","0I4P5H099","4221152623718651",192947);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Benson","Melendez","5296 stewart","San Francisco","94711","TJ94D6F7A","3554440861014316",61751);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Leonel","Slater","6140 eisenhower independence bl","Akron","44379","6Y3VWL15P","6384078621898260",694958);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Lisa","Schmidt","4639 stevenson ib lsd nb","Lubbock","79090","81LVTE8WZ","6518479381058351",102398);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Laney","House","5072 sell","Plano","75113","PVOR9GQNX","6771254169605992",516897);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Jensen","Santos","3062 lsd recreation dr","Ann Arbor","48154","RZGN6HGWT","6759595370096538",872799);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Adriana","Fitzgerald","708 little calumet river","San Jose","95941","36IYBGU0W","3574161817452212",936998);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Juliet","Ruiz","952 136th","Overland Park","66255","62WKRNNJ3","6011616878334306",584769);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Justin","Fuller","7861 yates","Lubbock","79398","P70Z1CY4B","6706553265398117",668915);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Taylor","Richard","9870 rascher","Knoxville","37143","BO8BGTZEI","4454690670284869",463560);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Braylin","Francis","8664 wood","Anchorage","99058","M62HU8O51","3542627373337889",507623);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Rayden","Rice","6793 levee","Fayetteville","72796","3RACGRO20","3567933388059389",610644);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Journee","Sanford","3121 moselle","Washington","20834","4O2VCCQHC","5483950354731219",400798);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Kadence","Skinner","6337 lamon","Cary","27511","5FE4DJ7GS","6304147430770833",107269);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Quinn","Brewer","306 34th","Aurora","60558","H5ZNHGL0M","4541367987982031",862454);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Sullivan","Webster","9031 newcastle","Baton Rouge","70354","ENT1FT1Z8","6381278974337576",174048);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Lola","Forbes","4215 kennedy racine av","Gainesville","32605","0XGJ7XQ95","30328581264156",305058);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Peter","Ross","4432 poplar","Dallas","75079","VW0A39UWM","5558182058099970",395642);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Donovan","Marsh","6978 houston","Lexington","405598","TYAMDCCNQ","6709281707877962",712255);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Simone","Oconnor","3668 lakewood","Manchester","03105","RE19D9DC3","370460976489433",585269);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Shania","Dean","8070 71st","Evansville","47726","A61N9KK79","346337498609949",505853);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Analia","Armstrong","1848 manor","Fontana","92313","5CR5I95ZM","36857742502199",102941);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Madison","Solomon","5642 dunbar","Baton Rouge","70749","YDRJ61Z8V","36745860407822",671266);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Joaquin","Henson","2853 north shore","Wichita","67080","KKJ1UZQI6","30233014827852",344507);
INSERT INTO employee (first_name, last_name, address_1, city, postcode, national_insurance,bank_account,salary) VALUES ("Emilio","Flores","7888 mcclellan","Augusta","30992","QBO4GKAJF","6519643073254540",276602);
INSERT INTO bu (name, directorid) VALUES ('Evolve', 43), ('Gov', 56), ('Enterprise', 31), ('Smart', 3), ('HR', 84), ('Finance', 61);
insert into emp_bu values (1,1);		
insert into emp_bu values (2,2);		
insert into emp_bu values (3,4);		
insert into emp_bu values (4,5);		
insert into emp_bu values (5,4);		
insert into emp_bu values (6,2);		
insert into emp_bu values (7,3);		
insert into emp_bu values (8,1);		
insert into emp_bu values (9,2);		
insert into emp_bu values (10,3);		
insert into emp_bu values (11,4);		
insert into emp_bu values (12,2);		
insert into emp_bu values (13,4);		
insert into emp_bu values (14,2);		
insert into emp_bu values (15,5);		
insert into emp_bu values (16,1);		
insert into emp_bu values (17,2);		
insert into emp_bu values (18,3);		
insert into emp_bu values (19,1);		
insert into emp_bu values (20,4);		
insert into emp_bu values (21,5);		
insert into emp_bu values (22,1);		
insert into emp_bu values (23,1);		
insert into emp_bu values (24,2);		
insert into emp_bu values (25,1);		
insert into emp_bu values (26,3);		
insert into emp_bu values (27,4);		
insert into emp_bu values (28,2);		
insert into emp_bu values (29,3);		
insert into emp_bu values (30,5);		
insert into emp_bu values (31,3);		
insert into emp_bu values (32,1);		
insert into emp_bu values (33,3);		
insert into emp_bu values (34,4);		
insert into emp_bu values (35,3);		
insert into emp_bu values (36,1);		
insert into emp_bu values (37,1);		
insert into emp_bu values (38,2);		
insert into emp_bu values (39,4);		
insert into emp_bu values (40,4);		
insert into emp_bu values (41,4);		
insert into emp_bu values (42,5);		
insert into emp_bu values (43,1);		
insert into emp_bu values (44,4);		
insert into emp_bu values (45,3);		
insert into emp_bu values (46,1);		
insert into emp_bu values (47,2);		
insert into emp_bu values (48,2);		
insert into emp_bu values (49,6);		
insert into emp_bu values (50,3);		
insert into emp_bu values (51,1);		
insert into emp_bu values (52,2);		
insert into emp_bu values (53,3);		
insert into emp_bu values (54,4);		
insert into emp_bu values (55,2);		
insert into emp_bu values (56,2);		
insert into emp_bu values (57,3);		
insert into emp_bu values (58,4);		
insert into emp_bu values (59,4);		
insert into emp_bu values (60,2);		
insert into emp_bu values (61,6);		
insert into emp_bu values (62,3);		
insert into emp_bu values (63,4);		
insert into emp_bu values (64,4);		
insert into emp_bu values (65,2);		
insert into emp_bu values (66,2);		
insert into emp_bu values (67,3);		
insert into emp_bu values (68,5);		
insert into emp_bu values (69,4);		
insert into emp_bu values (70,2);		
insert into emp_bu values (71,3);		
insert into emp_bu values (72,4);		
insert into emp_bu values (73,2);		
insert into emp_bu values (74,3);		
insert into emp_bu values (75,1);		
insert into emp_bu values (76,1);		
insert into emp_bu values (77,1);		
insert into emp_bu values (78,6);		
insert into emp_bu values (79,2);		
insert into emp_bu values (80,3);		
insert into emp_bu values (81,4);		
insert into emp_bu values (82,4);		
insert into emp_bu values (83,6);		
insert into emp_bu values (84,5);		
insert into emp_bu values (85,3);		
insert into emp_bu values (86,2);		
insert into emp_bu values (87,1);		
insert into emp_bu values (88,1);		
insert into emp_bu values (89,3);		
insert into emp_bu values (90,3);		
insert into emp_bu values (91,3);		
insert into emp_bu values (92,5);		
insert into emp_bu values (93,6);		
insert into emp_bu values (94,3);		
insert into emp_bu values (95,2);		
insert into emp_bu values (96,1);		
insert into emp_bu values (97,1);		
insert into emp_bu values (98,1);		
insert into emp_bu values (99,2);		
insert into emp_bu values (100,3);

INSERT INTO sales (sales_id,commission_rate,total_sales)VALUES (32, 0.1287, 400);
INSERT INTO sales (sales_id,commission_rate,total_sales)VALUES (45, 0.0762, 350);
INSERT INTO sales (sales_id,commission_rate,total_sales)VALUES (3, 0.1983, 1800);
INSERT INTO sales (sales_id,commission_rate,total_sales)VALUES (87, 0.21, 3100);
INSERT INTO sales (sales_id,commission_rate,total_sales)VALUES (71, 0.115, 9800);
INSERT INTO sales (sales_id,commission_rate,total_sales)VALUES (93, 0.1342, 7800);

CREATE VIEW EmployeesInBu AS (
SELECT CONCAT(first_name, ' ', last_name) as 'Employee Name', bu.name as 'BU Name' FROM employee
left join emp_bu on employee.employee_id = emp_bu.emp_id
right join bu on emp_bu.bu_id = bu.bu_id
where bu.name = "Evolve"
order by bu.name) ;

CREATE VIEW FinalSalary AS(
SELECT CONCAT(first_name,' ', last_name) as 'Employee Name', CONCAT('£',CAST((IFNULL((sales.commission_rate * sales.total_sales),0) + salary) as DECIMAL(11,2))) as 'Final Salary'from employee left outer JOIN sales on  employee.employee_id = sales.sales_id);






