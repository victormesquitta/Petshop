import { NavBarLogado } from "../../components/NavBarLogado/NavBarLogadoComponent";
import * as S from "./styles";
import cartao from "../../assets/images/creditcard.png";
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";
import { AuthService } from "../../services/AuthService";
import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';


type MeusCartoesProps = {
    authService: AuthService;
}

export function MeusCartoes(props: MeusCartoesProps) {
 
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

                        <section className='section'>
                    

                            
                            
                            <div>
                                <label>Numero do Cartão</label>
                                <input className='InputNumCard' placeholder="Numero do Cartão"/>
                            </div>
                            <div>
                                <label>CVC</label>
                                <input className='InputCVC' placeholder="Cvc" />
                                <label>Data</label>
                                <input className='InputData' placeholder="Data" />
                            </div>
                            <div>
                                <label>Nome Completo</label>
                                <input className='InputNome' placeholder="Nome Completo" />
                            </div>
                            
                            </section>
                            

                            <button className="Cadastro">Cadastrar</button>

                        




                    

                    </div>


            </S.ContainerMain>            
                <RodapeComponent />
            </S.ContainerPai>
        </>
    )
}