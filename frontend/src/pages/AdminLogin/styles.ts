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
@media (max-width: 1024px){
    .ImgLogo{
        top: 7.5rem;
    }
}

@media (max-width: 768px){
    .ImgLogo{
        height: 13vh;

        top: 15rem;
    }
}

@media (max-width: 480px){
        .ImgLogo{
            height: 11vh;

            top: 16rem;
        }
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

    @media (max-width: 1024px){
        width: 55%;
        height: 55%;
    }

    @media (max-width: 768px){
        width: 60%;
        height: 45%;
    }
@media (max-width: 480px){
    width: 70%;
    height: 45%;
}
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
@media (max-width: 1024px){
    width: 100%;

    h1{
        margin-top: 4rem;
        font-size: 4vw;
    }
    p{
        margin-top: .5rem;
        margin-bottom: 3rem;
        font-size: 2vw;
    }
}
    @media (max-width: 768px){
        width: 100%;

        h1{
            margin-top: 4rem;
            font-size: 4.5vw;
        }

        p{
            margin-top: .5rem;
            font-size: 2.3vw;
            
        }
    }

    @media (max-width: 480px){
        width: 100%;

        h1{
            margin-top: 4rem;
            font-size: 5.5vw;
        }

        p{
            margin-top: .5rem;
            font-size: 3vw;

            margin-bottom: 3.5rem;
            
        }
    }
`;

