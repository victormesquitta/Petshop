import styled from "styled-components";

export const InputSenha = styled.div`
display: flex;
flex-direction: column;
align-items: center;
gap: 1.5rem;
width: 100%;


    input {
        width: 55%;
        height: 2.7rem;

        border-radius: 15px;
        border: 1.5px solid;
        border-color: rgba(200, 200, 200, 0.5);

        padding-left: 1.5rem;
        padding-right: 3rem;     

            &:focus{
            background: whitesmoke;
            border: 0.1px solid rgb(104, 178, 224);
            outline: none !important;
        }  
    }

            .divOlhoAbertoOuFechado {
                width: 100%;
                
                display: flex;
                justify-content: center;

             &:last-child{
                position: relative;               

                .OlhoAbertoOuFechado {
                position: absolute;
                top: 50%;
                left: 70%;
                transform: translate(-50%, -50%);

                }
            }
        }
`