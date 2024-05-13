import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import * as S from "./styles";
import cartao from "../../assets/images/creditcard.png";
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";
import { AuthService } from "../../services/AuthService";
import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';


export function MeusCartoes(props) {
 
    return (
        <>
            <S.ContainerPai>
                <NavBarLogado authService={props.authService} />
                
            <S.ContainerMain>
            
                <InformacoesComponent />
                    <div className="DivTitle">
                        <h1 className = 'MeusCartoes'>Meus Cartões</h1>
                        <h4 className = 'NovoCartao'>Adicione seu novo cartão</h4>
                    </div>
                    
                    <div className="DivCadastroCartao">

                        <img src={cartao} className="FotoCartao"></img>
                        <h1 className="Titulo">Cadastre Seu Cartão</h1>
                        <h3 className="Subtitulo">Insira os dados do seu cartão</h3>

                        <section className='section'>

                            <label className='LabelNumCad'>Numero do Cartão</label>
                            <input className='InputNumCad' type="" placeholder="Numero do Cartão"/>
                            <label>Data</label>
                            <input className='InputCvc' type="month" placeholder="CVC" />

                            <label>CVC</label>
                            <input className='InputCvc' placeholder="CVC" />

                            <label >Nome Completo</label>
                            <input className='InputNome' placeholder="Nome Completo"/>

                        </section>
                            

                            <button className="Cadastro">Cadastrar</button>

                        




                    

                    </div>


            </S.ContainerMain>            
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}