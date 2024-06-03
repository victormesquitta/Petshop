import styled from 'styled-components';

export const ContainerPai = styled.div`
  width: 100%;
  height: 100vh;
`;

export const ContainerMain = styled.main`
  display: flex;
  align-items: flex-start; /* Alinhar itens ao início do contêiner (topo) */
  justify-content: flex-start; /* Alinhar itens ao início do contêiner (esquerda) */
  padding: 2rem;
  width: 100%;  

  .divMain {
    width: 100%;
    height: 100%;
    padding-left: 2rem;
    display: flex;
    flex-direction: column;
    align-items: flex-start; /* Alinhar itens ao início do contêiner (esquerda) */

    h1 {
      font-size: 2vw;
      color: #88ce08;
      margin: 20px 0
    }

    .form-container {
      width: 100%;
      max-width: 600px;
      background-color: #fff;
      padding: 20px;
      border: 2px solid #88ce08;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

      form {
        display: flex;
        flex-direction: column;

        label {
          margin-bottom: 5px;
          color: #333;
        }

        input {
          border: 2px solid #88ce08;
          border-radius: 10px;
          padding: 10px;
          margin-bottom: 15px;
          font-size: 14px;
          color: #333;
          width: calc(100% - 22px); 
        }

        input:focus {
          outline: none;
          border-color: #66bb6a;
        }

        .btn-editar {
          background-color: #88ce08;
          color: white;
          border: none;
          border-radius: 10px;
          padding: 10px;
          font-size: 16px;
          cursor: pointer;
          margin-top: 10px;
          text-align: center;
        }

        .btn-editar:hover {
          background-color: #76b107;
        }
      }
    }
  }
`;

