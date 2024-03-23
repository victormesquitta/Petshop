import styled from "styled-components";

export const ContainerCarousel = styled.div`
width: 100%;
margin: 0 auto;
min-height: 50vh;
display: flex;
align-items: center;
justify-content: center;

z-index: 2;

.inner{
  display: flex;
  
}

.item{
  height: 17rem;
  width: 100%;
  padding: 1.5rem;
  margin: .5rem;

  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  box-sizing: border-box;

  border-radius: 15px;
  border: 1px solid;
  border-color: lightgray;

  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  font-size: 1vw;  

  img{
    width: 50%;
    height: 40%;
    pointer-events: none;

  }

  h3{
    font-size: 1vw;
    margin-top: .5rem;

    width: 100%;
  }

  p{
    font-size: .9vw;

    margin-right: 1rem;
  }

  button{
    border: none;
    border-radius: 10px;

    background-color: #073950;
    color: white;

    height: 1.5rem;
    width: 70%;
    font-size: .8vw;
    font-weight: 600;

    margin-top: .5rem;
  }

  .Pedigree{
    margin-top: 1rem;
    padding-right: 2rem;

    display: flex;
    
  }

  .IconCoracao{
    position: relative;
    left: 2rem;

    height: 1.3rem;
    width: 1.5rem;

    color: red;    
  }

  .PrecoRiscado{
    text-decoration: line-through;
    
    margin-top: .5rem;
    padding-right: 1rem;

    width: 100%;

  }

  .PrecoNormal{
    margin-top: .2rem;

    font-size: 1.2vw;
    font-weight: 600;
  }

  .MimuPoints{
    color: gold;

    margin-top: 1rem;
  }
  
}

.carousel{
  overflow: hidden;

  border-radius: 10px;

  width: 60%;

  box-shadow: 10px 1px 10px rgba(0, 0, 0, 0.25);

}
`