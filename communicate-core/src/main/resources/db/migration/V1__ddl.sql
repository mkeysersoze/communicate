CREATE TABLE IF NOT EXISTS public."expression" (
	id bigserial NOT NULL,
	gender varchar(255) NULL,
	grammatical_classification varchar(255) NULL,
	plural varchar(255) NULL,
	"text" text NOT NULL,
	CONSTRAINT PK_EXPRESSION PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.meaning (
	id bigserial NOT NULL,
	"text" text NOT NULL,
	expression_id int8 NULL,
	CONSTRAINT PK_MEANING PRIMARY KEY (id)
);

ALTER TABLE public.meaning ADD CONSTRAINT FK_MEANING FOREIGN KEY (expression_id) REFERENCES expression(id);

CREATE TABLE IF NOT EXISTS public.example (
	id bigserial NOT NULL,
	"text" text NOT NULL,
	meaning_id int8 NULL,
	CONSTRAINT PK_EXAMPLE PRIMARY KEY (id)
);

ALTER TABLE public.example ADD CONSTRAINT FK_EXAMPLE FOREIGN KEY (meaning_id) REFERENCES meaning(id);

CREATE TABLE IF NOT EXISTS public.users (
	id bigserial NOT NULL,
	email varchar(255) NOT NULL,
	firstname varchar(16) NOT NULL,
	lastname varchar(16) NOT NULL,
	"password" varchar(16) NOT NULL,
	"role" int4 NULL,
	username varchar(16) NOT NULL,
	CONSTRAINT PK_USERS PRIMARY KEY (id)
);