import { useState } from 'react';
import { InformacoesComponent } from '../../components/InformacoesComponent/InformacoesComponent';
import { NavBarLogado } from '../../components/NavBarLogado/NavBarLogadoComponent';
import { RodapeComponent } from "../../components/RodapeComponent/RodapeComponent";
import * as S from './styles';

export function MeusDados(props) {
  const estados = [
    "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", 
    "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", 
    "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", 
    "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
  ];

  const [isEditing, setIsEditing] = useState(false);
  const [formData, setFormData] = useState({
    email: '',
    nome: '',
    cpf: '',
    celular: '',
    estado: '',
    cidade: '',
    logradouro: '',
    cep: '',
    bairro: '',
    numero: '',
    complemento: ''
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleEditClick = () => {
    setIsEditing(!isEditing);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isEditing) {
      // Lógica para salvar os dados
      console.log('Dados salvos:', formData);
    }
    setIsEditing(!isEditing);
  };

  return (
    <>
      <S.ContainerPai>
        <NavBarLogado authService={props.authService} />
        <S.ContainerMain>
          <InformacoesComponent />
          <S.DivMain>
            <h1 className="titulo">Meus Dados</h1>
            <h1 className="titulo">Meus Endereços</h1>
            <div className="form-container">
              <form onSubmit={handleSubmit}>
                <label htmlFor="email">E-mail</label>
                <input type="email" id="email" name="email" placeholder="Digite seu email" value={formData.email} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="nome">Nome</label>
                <input type="text" id="nome" name="nome" placeholder="Digite seu nome" value={formData.nome} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="cpf">CPF</label>
                <input type="text" id="cpf" name="cpf" placeholder="Digite seu CPF" maxLength={11} value={formData.cpf} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="celular">Celular</label>
                <input type="tel" id="celular" name="celular" placeholder="Digite seu celular" maxLength={11} value={formData.celular} onChange={handleInputChange} disabled={!isEditing} />

                <button type="submit" className="btn-editar">{isEditing ? 'Salvar' : 'Editar'}</button>
              </form>
            </div>
            <div className="form-container form-container-endereco">
              <form className='endereco' onSubmit={handleSubmit}>
                <label htmlFor="estado">Estado*</label>
                <select id="estado" name="estado" value={formData.estado} onChange={handleInputChange} disabled={!isEditing}>
                  <option value="">Escolha o estado</option>
                  {estados.map((estado, index) => (
                    <option key={index} value={estado}>{estado}</option>
                  ))}
                </select>

                <label htmlFor="cidade">Cidade*</label>
                <input type="text" id="cidade" name="cidade" className="half-width" placeholder="Digite sua cidade" value={formData.cidade} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="logradouro">Logradouro*</label>
                <input type="text" id="logradouro" name="logradouro" className="full-width" placeholder="Digite seu logradouro" value={formData.logradouro} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="cep">CEP*</label>
                <input type="text" id="cep" name="cep" className="half-width" placeholder="Digite seu CEP" maxLength={8} value={formData.cep} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="bairro">Bairro*</label>
                <input type="text" id="bairro" name="bairro" className="half-width" placeholder="Digite seu bairro" value={formData.bairro} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="numero">Número*</label>
                <input type="text" id="numero" name="numero" className="half-width" placeholder="Digite seu número" value={formData.numero} onChange={handleInputChange} disabled={!isEditing} />

                <label htmlFor="complemento">Complemento</label>
                <input type="text" id="complemento" name="complemento" className="half-width" placeholder="Digite seu complemento" value={formData.complemento} onChange={handleInputChange} disabled={!isEditing} />

                <button type="submit" className="btn-editar">{isEditing ? 'Salvar' : 'Editar'}</button>
              </form>
            </div>
          </S.DivMain>
        </S.ContainerMain>
        <RodapeComponent />
      </S.ContainerPai>
    </>
  );
}
