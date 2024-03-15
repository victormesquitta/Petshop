-- Pedido 1
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (1, '2024-03-10', '2024-03-09', '2024-03-09', '2024-03-15', 'Em processamento', 'Cartão de crédito', 150.00, 10.00, 'DESCONTO20', NULL, 1);

-- Pedido 2
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (2, '2024-03-15', '2024-03-14', '2024-03-14', '2024-03-20', 'Em trânsito', 'Boleto bancário', 200.00, 12.00, NULL, '2024-03-17', 2);

-- Pedido 3
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (3, '2024-03-20', '2024-03-19', '2024-03-19', '2024-03-25', 'Entregue', 'Transferência bancária', 180.00, 15.00, NULL, '2024-03-22', 3);

-- Pedido 4
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (4, '2024-03-25', '2024-03-24', '2024-03-24', '2024-03-30', 'Aguardando pagamento', 'Pix', 220.00, 18.00, NULL, NULL, 4);

-- Pedido 5
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (5, '2024-03-30', '2024-03-29', '2024-03-29', '2024-04-05', 'Em processamento', 'Cartão de crédito', 250.00, 20.00, 'DESCONTO15', NULL, 5);

-- Pedido 6
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (6, '2024-04-05', '2024-04-04', '2024-04-04', '2024-04-10', 'Em trânsito', 'Boleto bancário', 180.00, 15.00, NULL, '2024-04-08', 6);

-- Pedido 7
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (7, '2024-04-10', '2024-04-09', '2024-04-09', '2024-04-15', 'Entregue', 'Transferência bancária', 200.00, 12.00, NULL, '2024-04-13', 7);

-- Pedido 8
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (8, '2024-04-15', '2024-04-14', '2024-04-14', '2024-04-20', 'Aguardando pagamento', 'Pix', 220.00, 18.00, NULL, NULL, 8);

-- Pedido 9
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (9, '2024-04-20', '2024-04-19', '2024-04-19', '2024-04-25', 'Em processamento', 'Cartão de crédito', 250.00, 20.00, 'DESCONTO20', NULL, 9);

-- Pedido 10
INSERT INTO t_pedido (codpedido, dtpedido, dtcriacao, dtmodificacao, dtentrega, status, mtdpagamento, subtotal, taxaenvio, cupomdesconto, dtenvio, codcliente)
VALUES (10, '2024-04-25', '2024-04-24', '2024-04-24', '2024-04-30', 'Em trânsito', 'Boleto bancário', 280.00, 22.00, NULL, '2024-04-28', 10);