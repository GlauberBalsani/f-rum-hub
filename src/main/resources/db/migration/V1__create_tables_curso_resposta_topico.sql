-- Tabela "usuario"
CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Tabela "cursos"
CREATE TABLE cursos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

-- Tabela "topico"
CREATE TABLE topico (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT,
    dataCriacao DATETIME,
    status VARCHAR(50),
    autor_id BIGINT,
    curso_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

-- Tabela "respostas"
CREATE TABLE respostas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    mensagem TEXT,
    dataCriacao DATETIME,
    autor_id BIGINT,
    solucao VARCHAR(255),
    topico_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (topico_id) REFERENCES topico(id)
);
