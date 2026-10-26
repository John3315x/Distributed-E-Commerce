--
-- PostgreSQL database dump
--

\restrict keikFfihrNHtABTUvyC0uAFdDdMK2iVe1ZQlykuzTxfULgbLmx9qrWCsDznntdU

-- Dumped from database version 18.4 (Debian 18.4-1.pgdg13+1)
-- Dumped by pg_dump version 18.3

-- Started on 2026-07-08 11:47:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16439)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    password_hash text NOT NULL,
    role character varying(20) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT users_role_check CHECK (((role)::text = ANY (ARRAY[('USER'::character varying)::text, ('ADMIN'::character varying)::text, ('SUPPORT'::character varying)::text, ('AUDITOR'::character varying)::text])))
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16451)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3450 (class 0 OID 0)
-- Dependencies: 220
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3289 (class 2604 OID 16452)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3443 (class 0 OID 16439)
-- Dependencies: 219
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, username, email, password_hash, role, created_at) FROM stdin;
16	publicuserC01	publicuserC01@test.com	$2a$10$lKC0eogPIjQeNHI6Z5mX8eAvzps8goEuoQQQXLxF1mf6D8eX5ehO6	SUPPORT	2026-07-08 16:00:02.574376
20	publicuserB01	publicuserB01@test.com	$2a$10$un0IBRT6Er/f5LmCK.9CfugKfs9PXjwIPGrGHqyR4oitoAc5jyXqm	ADMIN	2026-07-08 17:43:57.459983
21	publicuserA01	publicuserA01@test.com	$2a$10$90ChrNII2VkYnCIglW.l.ubFr1EbESGlsNp73l1qsJFvgXY72FR7G	USER	2026-07-08 17:45:08.135423
\.


--
-- TOC entry 3451 (class 0 OID 0)
-- Dependencies: 220
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 21, true);


--
-- TOC entry 3293 (class 2606 OID 16454)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 3295 (class 2606 OID 16456)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2026-07-08 11:47:35

--
-- PostgreSQL database dump complete
--

\unrestrict keikFfihrNHtABTUvyC0uAFdDdMK2iVe1ZQlykuzTxfULgbLmx9qrWCsDznntdU

