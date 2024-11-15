create table Appointment
(
	id bigint not null,
	patient_id bigint not null,
	appointmentDateTime varchar(255) not null,
	doctorName varchar(255) not null,
	appointmentType varchar(255) not null,
	notes varchar(255) not null,
	status varchar(255) not null,
	primary key (id)

);