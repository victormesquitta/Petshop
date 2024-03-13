import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
.roboto-thin {
    font-family: "Roboto", sans-serif;
    font-weight: 100;
    font-style: normal;
  }
  
  .roboto-light {
    font-family: "Roboto", sans-serif;
    font-weight: 300;
    font-style: normal;
  }
  
  .roboto-regular {
    font-family: "Roboto", sans-serif;
    font-weight: 400;
    font-style: normal;
  }
  
  .roboto-medium {
    font-family: "Roboto", sans-serif;
    font-weight: 500;
    font-style: normal;
  }
  
  .roboto-bold {
    font-family: "Roboto", sans-serif;
    font-weight: 700;
    font-style: normal;
  }
  
  .roboto-black {
    font-family: "Roboto", sans-serif;
    font-weight: 900;
    font-style: normal;
  }
  
  .roboto-thin-italic {
    font-family: "Roboto", sans-serif;
    font-weight: 100;
    font-style: italic;
  }
  
  .roboto-light-italic {
    font-family: "Roboto", sans-serif;
    font-weight: 300;
    font-style: italic;
  }
  
  .roboto-regular-italic {
    font-family: "Roboto", sans-serif;
    font-weight: 400;
    font-style: italic;
  }
  
  .roboto-medium-italic {
    font-family: "Roboto", sans-serif;
    font-weight: 500;
    font-style: italic;
  }
  
  .roboto-bold-italic {
    font-family: "Roboto", sans-serif;
    font-weight: 700;
    font-style: italic;
  }
  
  .roboto-black-italic {
    font-family: "Roboto", sans-serif;
    font-weight: 900;
    font-style: italic;
  }
  

#root {
        width: 100%;
        height: 100vh; 
        display: flex;
        align-items: center;
        justify-content: center;
    }

 * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;

    }

html {
    @media (max-width: 1000px){
        font-size: 93.75%; //15 px
    }

    @media (max-width: 720px){
        font-size: 87.5%; //14px
    }
}

body {
    background-color: var(--background);

    -webkit-font-smoothing: antialiased;
    width: 100%;

    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

body, input, textarea, button{
    font-family:'Poppins', sans-serif;
    font-weight: 400;
}

h1, h2, h3, h4, h5, h6, strong{
    font-weight: 600;
}

button{
    cursor:pointer;
}

[disabled]{
    opacity: 0.6;
    cursor: not-allowed;
}

.react-modal-overlay{
    background: rgba(0, 0, 0, 0.5);

    position: fixed;
    top: 0;
    bottom: 0;
    right: 0;
    left: 0;

    display: flex;
    align-items: center;
    justify-content: center;
}

.react-modal-content{
    width: 100%;
    max-width: 576px;
    background: var(--background);
    padding: 3rem;
    position: relative;
    border-radius: 0.25rem;
}

.react-modal-close{
    position: absolute;
    right: 1.5rem;
    top: 1.5rem;
    border: 0;
    background: transparent;

    transition: filter 0.2s;
    
    &:hover {
        filter: brightness(0.8);
    }
}
`