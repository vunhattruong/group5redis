-- Drop table

-- DROP TABLE public.users;
CREATE TABLE public.users (
	id uuid NOT NULL,
	address varchar(255) NULL,
	created_date date NOT NULL,
	email varchar(255) NULL,
	full_name varchar(255) NULL,
	modified_date date NOT NULL,
	phone_number varchar(255) NULL,
	user_name varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);