import styled from "styled-components";
import ImgCaesFundo from "../../assets/images/ImgCaesFundo.svg";

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

background-image: url(${ImgCaesFundo});
background-size: cover;
background-repeat: no-repeat;
background-position: bottom;
min-height: 100vh;
min-width: 100vw;

.ImgLogo{
    position: absolute;
    
    left: .5rem;
    top: .5rem;

    height: 20vh;
}
`

export const FormularioLogin = styled.form` 
    background-color: white;
    width: 40%; 
    
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content:center;

    border: .5px solid;
    border-color: rgba(200, 200, 200, 0.5);
    border-radius:25px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);

    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;

`;

export const Inputs = styled.div`
display: flex;
flex-direction: column;
align-items: center;
width: 100%;

h1{
    margin-top: 2.5rem;
    margin-bottom: 3.5rem;
    font-size: 2.5vw;
    font-family: 'roboto-medium', sans-serif;
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
        
        margin-top: .5rem;
    }

} 

    div{
        width:59%;
        padding-bottom: 1.6rem;
        display: flex;
        flex-direction: column;
        gap: 1rem;

    }

       .LogarCom{
             position: relative;
             top: .3rem;

            padding-left: 1.5rem;
            padding-right: 1.5rem; 
     } 

`;

export const ImgsLogos = styled.div`
    width: 100%;

   display: flex;
   flex-direction: row;
   position: relative;

   justify-content: space-evenly;

   padding: 1rem;
   
   div{
    margin-top: .5rem;
    margin-bottom: .5rem;
    
    width: 20%;
    height: 2.5rem; 

    border-radius: 20px;

    &.divFacebook{
        background-color: #1976D2;

        display: flex;
        align-items: center;
        justify-content: center;

        .ImgFacebook{            
            cursor: pointer;

            color: white;

            width: 2rem;
            height: 1.7rem;
        }
    }

    &.divGoogle{
        background-color: white;

        display: flex;
        align-items: center;
        justify-content: center;

        border: 2px solid;
        border-color: rgba(200, 200, 200, 0.5);
;

        .ImgGoogle{
            cursor: pointer;

            color: red;
            
            width: 2rem;
            height: 1.7rem;

        }
    }

    &.divApple{
        background-color: black;

        display: flex;
        align-items: center;
        justify-content: center;
    
        .ImgApple{   
            cursor: pointer;

            color: white;

            width: 2rem;
            height: 1.7rem;

        }
    }
}`;
