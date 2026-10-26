--
-- PostgreSQL database dump
--

\restrict 8ayc7VFsLRCA2u9pMJkILjdZ00h2I9kcGaNvYOvaQesGNohxfWXcAGyHaBU2W6z

-- Dumped from database version 18.4 (Debian 18.4-1.pgdg13+1)
-- Dumped by pg_dump version 18.3

-- Started on 2026-07-08 10:14:47

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
-- TOC entry 219 (class 1259 OID 16389)
-- Name: security_logs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.security_logs (
    id integer NOT NULL,
    user_id integer,
    event_type character varying(50) NOT NULL,
    ip character varying(45),
    user_agent text,
    details text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.security_logs OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16397)
-- Name: security_logs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.security_logs_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.security_logs_id_seq OWNER TO postgres;

--
-- TOC entry 3477 (class 0 OID 0)
-- Dependencies: 220
-- Name: security_logs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.security_logs_id_seq OWNED BY public.security_logs.id;


--
-- TOC entry 221 (class 1259 OID 16398)
-- Name: sessions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sessions (
    id integer NOT NULL,
    user_id integer NOT NULL,
    token_id character varying(36) NOT NULL,
    refresh_token_hash text NOT NULL,
    ip character varying(45),
    user_agent text,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    expires_at timestamp without time zone NOT NULL,
    revoked boolean DEFAULT false
);


ALTER TABLE public.sessions OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16410)
-- Name: sessions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sessions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.sessions_id_seq OWNER TO postgres;

--
-- TOC entry 3478 (class 0 OID 0)
-- Dependencies: 222
-- Name: sessions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sessions_id_seq OWNED BY public.sessions.id;


--
-- TOC entry 223 (class 1259 OID 16411)
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
-- TOC entry 224 (class 1259 OID 16423)
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
-- TOC entry 3479 (class 0 OID 0)
-- Dependencies: 224
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3299 (class 2604 OID 16424)
-- Name: security_logs id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.security_logs ALTER COLUMN id SET DEFAULT nextval('public.security_logs_id_seq'::regclass);


--
-- TOC entry 3301 (class 2604 OID 16425)
-- Name: sessions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sessions ALTER COLUMN id SET DEFAULT nextval('public.sessions_id_seq'::regclass);


--
-- TOC entry 3304 (class 2604 OID 16426)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3466 (class 0 OID 16389)
-- Dependencies: 219
-- Data for Name: security_logs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.security_logs (id, user_id, event_type, ip, user_agent, details, created_at) FROM stdin;
\.


--
-- TOC entry 3468 (class 0 OID 16398)
-- Dependencies: 221
-- Data for Name: sessions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sessions (id, user_id, token_id, refresh_token_hash, ip, user_agent, created_at, expires_at, revoked) FROM stdin;
\.


--
-- TOC entry 3470 (class 0 OID 16411)
-- Dependencies: 223
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, username, email, password_hash, role, created_at) FROM stdin;
\.


--
-- TOC entry 3480 (class 0 OID 0)
-- Dependencies: 220
-- Name: security_logs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.security_logs_id_seq', 62, true);


--
-- TOC entry 3481 (class 0 OID 0)
-- Dependencies: 222
-- Name: sessions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sessions_id_seq', 54, true);


--
-- TOC entry 3482 (class 0 OID 0)
-- Dependencies: 224
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 10, true);


--
-- TOC entry 3308 (class 2606 OID 16428)
-- Name: security_logs security_logs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.security_logs
    ADD CONSTRAINT security_logs_pkey PRIMARY KEY (id);


--
-- TOC entry 3310 (class 2606 OID 16430)
-- Name: sessions sessions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sessions
    ADD CONSTRAINT sessions_pkey PRIMARY KEY (id);


--
-- TOC entry 3312 (class 2606 OID 16432)
-- Name: sessions sessions_refresh_token_hash_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sessions
    ADD CONSTRAINT sessions_refresh_token_hash_key UNIQUE (refresh_token_hash);


--
-- TOC entry 3314 (class 2606 OID 16434)
-- Name: sessions sessions_token_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sessions
    ADD CONSTRAINT sessions_token_id_key UNIQUE (token_id);


--
-- TOC entry 3316 (class 2606 OID 16436)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 3318 (class 2606 OID 16438)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2026-07-08 10:14:48

--
-- PostgreSQL database dump complete
--

\unrestrict 8ayc7VFsLRCA2u9pMJkILjdZ00h2I9kcGaNvYOvaQesGNohxfWXcAGyHaBU2W6z

