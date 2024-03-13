import styled from "styled-components";
import ImgFundoAdmLogin from "../../assets/images/ImgFundoAdmLogin.png"


export const ContainerPai = styled.div`
*{
    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;
}

width: 100%; 
height: 100%; 

display: flex;
align-items: center;
justify-content: center;

background-image: url(${ImgFundoAdmLogin});
background-size: cover;
background-position: center;
width: 100vw; /* 100% da largura da viewport */
height: 100vh; /* 100% da altura da viewport */

.ImgLogo{
    position: absolute;
    top: 1rem;

    height: 18vh;

    border: .5px solid;
    border-color: rgba(200, 200, 200, 0.5);
    border-radius: 70px;

}
`

export const FormularioLogin = styled.form` 
    background-color: white;
    width: 36%; 
    height:27rem;

    display: flex;
    flex-direction: column;
    align-items: center;

    padding-top:3rem;
    gap: 2rem;

    border-color: rgba(200, 200, 200, 0.5);
    border-radius: 15px;
    box-shadow: .1rem .5rem .5rem rgba(0, 0, 0, 0.4);

    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;

`;

export const Inputs = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 120%;

    h1{
        margin-top: 1.2rem;
        font-size: 2.8vw;
        font-weight: 550;
        font-family: 'roboto-medium', sans-serif;
    }

    p{
        line-height: 2rem;
        margin-bottom: 2rem;
    }
`;
export const NaoTemConta = styled.div`
    display: flex;
    position: relative;
    flex-direction: column;    
    align-items: center;

    width: 100%;

    div.divButton{
        display: flex;
        position: relative;
        flex-direction: row;
        justify-content: center;

        width: 100%;

    button{
            background-color: #1976D2;
            color: white;
        
            border: none;
            border-radius: 15px;
        
            width: 30%;
            height: 2.7rem;
            
        }
    } 
`;
