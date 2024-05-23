INSERT INTO TRAIN_DETAIL (TRAIN_NUMBER, TRAIN_NAME, TRAIN_TYPE, SOURCE_STATION, DESTINATION_STATION,TOTAL_NUMBER_OF_SEATS,TRAIN_BETWEEN_STATIONS, TRAIN_SECTIONS) VALUES(100001, 'Train100001', 'SF', 'London', 'France', 100, 'Station1,Station2,Station3', 'SECTION_A,SECTION_B');
INSERT INTO TRAIN_DETAIL (TRAIN_NUMBER, TRAIN_NAME, TRAIN_TYPE, SOURCE_STATION, DESTINATION_STATION,TOTAL_NUMBER_OF_SEATS,TRAIN_BETWEEN_STATIONS, TRAIN_SECTIONS) VALUES(100002, 'Train100002', 'SF', 'France', 'London', 100, 'Station1,Station2,Station3', 'SECTION_A,SECTION_B');

INSERT INTO TRAIN_TICKET_FARE (TRAIN_NUMBER,TRAIN_TYPE,TICKET_COST) VALUES (100001, 'SF', 5);
INSERT INTO TRAIN_TICKET_FARE (TRAIN_NUMBER,TRAIN_TYPE,TICKET_COST) VALUES (100002, 'SF', 6);

INSERT INTO TRAIN_TICKET_AVAILABILITY (TRAIN_NUMBER,TRAIN_SECTION,AVAILABLE_SEATS) VALUES (100001, 'SECTION_A', 40);
INSERT INTO TRAIN_TICKET_AVAILABILITY (TRAIN_NUMBER,TRAIN_SECTION,AVAILABLE_SEATS) VALUES (100001, 'SECTION_B', 60);
INSERT INTO TRAIN_TICKET_AVAILABILITY (TRAIN_NUMBER,TRAIN_SECTION,AVAILABLE_SEATS) VALUES (100002, 'SECTION_A', 30);
INSERT INTO TRAIN_TICKET_AVAILABILITY (TRAIN_NUMBER,TRAIN_SECTION,AVAILABLE_SEATS) VALUES (100002, 'SECTION_B', 70);