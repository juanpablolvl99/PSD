/*create database threadLove;*/

create table usuario(
    id int primary key,
    login varchar(50) not null unique,
    senha varchar(30) not null,
    nome varchar(100) not null,
    apelido varchar(30) not null,
    dataNascimento date not null,
    cidade varchar(50),
    email varchar(50) not null unique,
    profissao varchar(100),
    descricao text not null,
    status varchar(50) not null,
    altura real,
    peso real,
    corDoCabelo varchar(30),
    passatempos text not null,
    fotoPerfil varchar(30)
);

create table galeria(
    email varchar(50) references usuario(email),
    foto varchar(30),
    primary key(email, foto)
);

create table mensagem(
    de varchar(50) references usuario(email),
    para varchar(50),
    mensagem text ,
    primary key(de, para, mensagem)
);

create table amizade(
    usuario varchar(50) references usuario(email),
    amigo varchar(50),
    primary key(usuario, amigo)
);

create table pedidosAmizade(
    usuario varchar(50) references usuario(email),
    convite varchar(50),
    primary key(usuario, convite)
)
