import styled from "styled-components";

export const ContainerPai = styled.div`
  width: 100%;
  height: 100%;

  margin: 0 auto;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  gap: 1rem;

  .toastContainer {
    width: 20%;

    margin-top: 3.5rem;
  }

  .sectionButtons{
    display: flex;
    align-items: center;
    justify-content: space-evenly;

    width: 50%;
    button{
      border: 1px solid gray;
      border-radius: 10px;

      width: 20%;
      height: 1.5rem;
    }
  }

  li {
    margin-top: 2rem;
  }

  .show {
    display: block; /* Exibe o modal */
    position: fixed; /* Posiciona o modal fixo na tela */
    z-index: 1; /* Define o índice Z para o modal, garantindo que ele fique em cima de outros elementos */
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto; /* Permite rolagem se o conteúdo do modal exceder a altura da tela */
    background-color: rgba(0, 0, 0, 0.4);

    div {
      background-color: #fefefe; /* Define a cor de fundo do conteúdo do modal */
      margin: 15% auto; /* Define as margens para centralizar o modal na tela */
      padding: 20px;
      border: 1px solid #888; /* Adiciona uma borda ao conteúdo do modal */
      width: 80%; /* Define a largura do conteúdo do modal */

      table {
        width: 100%; /* Define a largura da tabela como 100% */
        border-collapse: collapse; /* Remove o espaçamento entre as células */

        background-color: #f0f0f0;

        th {
          text-align: left; /* Alinha o texto à esquerda */
          padding: 8px; /* Adiciona espaçamento entre o texto e as bordas da célula */
          background-color: #f0f0f0;
        }

        td {
          text-align: left; /* Alinha o texto à esquerda */
          padding: 8px; /* Adiciona espaçamento entre o texto e as bordas da célula */
        }
      }

      tr:nth-child(even) {
        background-color: #f2f2f2; /* Define a cor de fundo para linhas pares da tabela */
      }
    }

    button {
      float: right; /* Alinha o botão de fechar à direita */
      font-size: 28px;
      font-weight: bold;
      /* Adiciona estilos ao botão de fechar */

      &:hover {
        color: #000; /* Altera a cor do botão ao passar o mouse ou focar */
        text-decoration: none;
        cursor: pointer; /* Define o cursor como ponteiro para indicar que o elemento é clicável */
      }

      &:focus {
        color: #000; /* Altera a cor do botão ao passar o mouse ou focar */
        text-decoration: none;
        cursor: pointer; /* Define o cursor como ponteiro para indicar que o elemento é clicável */
      }
    }
  }
`;
