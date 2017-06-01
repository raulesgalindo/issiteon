CREATE TABLE icon(
    id INT PRIMARY KEY NOT NULL AUTOINCREMENT,
    icon BLOB,
);
CREATE TABLE alarm_counter(
    id INT PRIMARY KEY NOT NULL AUTOINCREMENT,
    is_active NUMERIC,
    is_alarm_active NUMERIC,
    remaining_time INT
);
CREATE TABLE site(
    id INT PRIMARY KEY NOT NULL AUTOINCREMENT,
    url TEXT,
    notify_time INT,
    id_icon INT,
    id_alarm_counter INT,
    FOREIGN KEY(id_icon) REFERENCES icon(id),
    FOREIGN KEY(id_alarm_counter) REFERENCES alarm_counter(id)
);
CREATE TABLE log{
    id INT PRIMARY KEY NOT NULL AUTOINCREMENT,
    status INT,
    log_timestamp TEXT,
    id_site INT,
    FOREIGN KEY(id_site) REFERENCES site(id)
}