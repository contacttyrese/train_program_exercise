CREATE TABLE train_driver_details
(    journey_id NUMBER(3) NOT NULL,
    train_id VARCHAR2(4),
    start_station VARCHAR2(255),
    end_station VARCHAR2(255),
    driver_name VARCHAR2(255),
    journey_status VARCHAR2(255)
);

ALTER TABLE train_driver_details
    ADD (
    CONSTRAINT journey_driver_pk PRIMARY KEY (journey_id)
    );

CREATE TABLE train_delay_details
(    journey_id NUMBER(3) NOT NULL,
    train_id VARCHAR2(4),
    station VARCHAR2(255),
    departure_time VARCHAR2(255),
    departure_late_in_secs VARCHAR2(255)
);

ALTER TABLE train_delay_details
    ADD (
    CONSTRAINT journey_delay_pk PRIMARY KEY (journey_id)
    );
