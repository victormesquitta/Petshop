import styled from "styled-components";

export const ContainerPai = styled.div`
*{
    font-size: 1vw;;
    font-family: 'Roboto', sans-serif;
}

width: 100%;
height: 100%;

`
export const DivMain = styled.div`

display: flex;
align-items: center;
flex-direction: column;

.DivImgTransition{
    margin-top: 3rem;

    width: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    
    gap: 3.5rem;
    img{
        width: 70%;
        background-color: white;
    }

    h2{
        font-size: 1.4vw;
        letter-spacing: .1rem;
    }
}

.DivCards{
    width: 90%;

    margin-bottom: 2rem;

    display: flex;
    align-items: center;
    justify-content: space-around;

    section{
        flex-direction: column;
        display: flex;
        align-items: center;
        justify-content: space-evenly;

        border: 1.5px solid;
        border-color: lightgray;
        border-radius: 25px;

        width: 22%;
        height: 18rem;

        padding: 2.5rem;
        margin-top: 3.5rem;

        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        
        img{
            width: 80%;
            height: 11rem;
            
        }

        h3{
            margin-top: 1rem; 

            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;

            font-size: 1vw;
            
            p{
            margin-top: .5rem;
    
            display: flex;
            align-items: center;
            justify-content: center;
          
            width: 100%;
            font-size: 1.2vw;

            }
            .TextoRiscado{
                text-decoration: line-through;
            }
        }  
    }
}
.ParaPrincipaisMarcas{
    margin-top: 2.5rem;
    margin-bottom: 3rem;

    .PrincipaisMarcasTitulo{
    font-size: 1.4vw;
    letter-spacing: .1rem;

}
}
    
`
export const ContainerMarcas = styled.section`
flex-direction: column;

padding-top: 1.5rem;
padding-bottom: 1.5rem;
background-color:  #88CE08 ;

section{
    display: flex;
    justify-content: space-evenly;
    align-items: center;

    width: 100%;

    img{
    width: 10%;
}
}
.SectionImgs{
    img{
        margin-top: 1rem;
    }

    .ImgElano{
        background-color: white;

        height: 8.4rem;
    }
}

`