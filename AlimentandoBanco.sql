// Categoria
INSERT INTO t_categoria (nome, descricao, destaque, ativa, dtcriacao)
VALUES ('Cachorro', 'Produtos relacionados a cachorros.', TRUE, TRUE, '2024-01-02');
INSERT INTO t_categoria (nome, descricao, destaque, ativa, dtcriacao)
VALUES ('Gato', 'Produtos relacionados a gatos.', TRUE, TRUE, '2024-01-03');
INSERT INTO t_categoria (nome, descricao, destaque, ativa, dtcriacao)
VALUES ('Pássaro', 'Produtos relacionados a pássaros.', TRUE, TRUE, '2024-01-04');
INSERT INTO t_categoria (nome, descricao, destaque, ativa, dtcriacao)
VALUES ('Peixe', 'Produtos relacionados a peixes.', TRUE, TRUE, '2024-01-05');
INSERT INTO t_categoria (nome, descricao, destaque, ativa, dtcriacao)
VALUES ('Outros', 'Produtos para outros animais de estimação.', TRUE, TRUE, '2024-01-06');


// Subcategoria
INSERT INTO t_subcategoria (codcategoria, nome, descricao, destaque, ativa, dtcriacao)
VALUES (1, 'Ração Seca', 'Ração seca para cachorros.', TRUE, TRUE, '2024-01-02');
INSERT INTO t_subcategoria (codcategoria, nome, descricao, destaque, ativa, dtcriacao)
VALUES (2, 'Areia Sanitária', 'Areia sanitária para gatos.', TRUE, TRUE, '2024-01-03');

// Produto
INSERT INTO t_produto (codsubcategoria, nome, descricao, preco, qtdestoque, marca, disponivel, dtcriacao, destaque)
VALUES (1, 'Ração Premium', 'Ração de alta qualidade para cães adultos.', 49.99, 100, 'PetFood', TRUE, '2024-01-02', TRUE);
INSERT INTO t_produto (codsubcategoria, nome, descricao, preco, qtdestoque, marca, disponivel, dtcriacao, destaque)
VALUES (2, 'Areia de Sílica', 'Areia de sílica para controle de odor.', 15.99, 50, 'KittyClean', TRUE, '2024-01-03', TRUE);
INSERT INTO t_produto (codsubcategoria, nome, descricao, preco, qtdestoque, marca, disponivel, dtcriacao, destaque)
VALUES (3, 'Gaiola para Calopsita', 'Gaiola espaçosa para calopsitas.', 89.99, 20, 'BirdHaven', TRUE, '2024-01-04', TRUE);
INSERT INTO t_produto (codsubcategoria, nome, descricao, preco, qtdestoque, marca, disponivel, dtcriacao, destaque)
VALUES (4, 'Alimento em Flocos Tropical', 'Alimento em flocos para peixes tropicais.', 12.99, 80, 'AquaLife', TRUE, '2024-01-05', TRUE);
INSERT INTO t_produto (codsubcategoria, nome, descricao, preco, qtdestoque, marca, disponivel, dtcriacao, destaque)
VALUES (5, 'Terrário de Vidro', 'Terrário de vidro para répteis pequenos.', 69.99, 10, 'ReptiHabitat', TRUE, '2024-01-06', TRUE);

// Cliente
-- João Silva
INSERT INTO t_cliente (nomecompleto, usuario, senha, email, cpf, celular, celular2, dtnascimento, dtcadastro, status, prefmarketing, role)
VALUES ('João Silva', 'joaosilva1', 'senha123', 'joao1@example.com', '123.456.789-01', '999999999', '888888888', '1990-05-15', '2022-03-01', 'ativo', true, 'USER');
