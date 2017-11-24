package com.falacascudo.models;


import android.content.res.Resources;
import android.util.Log;

import com.falacascudo.MainActivity;
import com.falacascudo.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by carlo on 23/10/2017.
 */

public enum EnumEstadosMunicipios {
    RN(municipiosRN(),"Rio Grande do Norte");

    public ArrayList<String> municipios;
    public String nome;


    public ArrayList<String> getMunicipios() {
        return municipios;
    }

    EnumEstadosMunicipios(ArrayList<String> municipios, String nome){
        this.municipios = municipios;
        this.nome = nome;
    }


    public void setMunicipios(ArrayList<String> municipios) {
        this.municipios = municipios;
    }



    /**
     *
     * @param id
     * @return
     */
    public static EnumEstadosMunicipios getEstadoById(int id){


        for (EnumEstadosMunicipios estado : EnumEstadosMunicipios.values()) {
            if(EnumEstadosMunicipios.valueOf(estado.toString()).ordinal() == id){
                return EnumEstadosMunicipios.valueOf(estado.getNome());
            }
        }

        return null;
    }

    public static ArrayList<String> listaEstados(){
        ArrayList<String> lista = new ArrayList<String>();
        for (EnumEstadosMunicipios estado : EnumEstadosMunicipios.values()) {
            lista.add(estado.getNome());
        }
        return lista;
    }

    public static EnumEstadosMunicipios getEstadoByName(String name){
        EnumEstadosMunicipios result = null;
        for (EnumEstadosMunicipios estado : EnumEstadosMunicipios.values()) {
            if(estado.getNome().equals(name)){
                result = estado;
            }
        }
        return result;
    }



    public String getMunicipioById(int id){
        return this.municipios.get(id);
    }

    public String getNome() {
        return nome;
    }









//========================  Listagem de cidades  =====================

    public static ArrayList<String> municipiosRN(){

        ArrayList<String> municipios = new ArrayList<String>();

        municipios.add("Natal");
        municipios.add("Mossoró");
        municipios.add("Parnamirim");
        municipios.add("São Gonçalo do Amarante");
        municipios.add("Macaíba");
        municipios.add("Ceará-Mirim");
        municipios.add("Caicó");
        municipios.add("Assu");
        municipios.add("Currais Novos");
        municipios.add("São José de Mipibu");
        municipios.add("Santa Cruz");
        municipios.add("Nova Cruz");
        municipios.add("Apodi");
        municipios.add("João Câmara");
        municipios.add("Touros");
        municipios.add("Canguaretama");
        municipios.add("Macau");
        municipios.add("Pau dos Ferros");
        municipios.add("Areia Branca");
        municipios.add("Extremoz");
        municipios.add("Baraúna");
        municipios.add("Nísia Floresta");
        municipios.add("Goianinha");
        municipios.add("Santo Antônio");
        municipios.add("São Miguel");
        municipios.add("Monte Alegre");
        municipios.add("Parelhas");
        municipios.add("Caraúbas");
        municipios.add("Jucurutu");
        municipios.add("São Paulo do Potengi");
        municipios.add("Tangará");
        municipios.add("Pedro Velho");
        municipios.add("Lagoa Nova");
        municipios.add("Poço Branco");
        municipios.add("Ipanguaçu");
        municipios.add("Santana do Matos");
        municipios.add("Jardim de Piranhas");
        municipios.add("Alexandria");
        municipios.add("Pendências");
        municipios.add("Upanema");
        municipios.add("Arez");
        municipios.add("Guamaré");
        municipios.add("Governador Dix-Sept Rosado");
        municipios.add("São José do Campestre");
        municipios.add("Alto do Rodrigues");
        municipios.add("Ielmo Marinho");
        municipios.add("Jardim do Seridó");
        municipios.add("Patu");
        municipios.add("Taipu");
        municipios.add("Brejinho");
        municipios.add("Angicos");
        municipios.add("Montanhas");
        municipios.add("Tibau do Sul");
        municipios.add("Passa-e-Fica");
        municipios.add("Acari");
        municipios.add("Cerro Corá");
        municipios.add("Afonso Bezerra");
        municipios.add("São Tomé");
        municipios.add("Vera Cruz");
        municipios.add("Umarizal");
        municipios.add("Espírito Santo");
        municipios.add("Maxaranguape");
        municipios.add("Lajes");
        municipios.add("Serra do Mel");
        municipios.add("Campo Redondo");
        municipios.add("Rio do Fogo");
        municipios.add("Tenente Ananias");
        municipios.add("Carnaubais");
        municipios.add("Luís Gomes");
        municipios.add("Bom Jesus");
        municipios.add("Grossos");
        municipios.add("Campo Grande");
        municipios.add("Boa Saúde");
        municipios.add("Florânia");
        municipios.add("Serra Caiada");
        municipios.add("São Miguel do Gostoso");
        municipios.add("Baía Formosa");
        municipios.add("Pureza");
        municipios.add("Marcelino Vieira");
        municipios.add("Martins");
        municipios.add("São Rafael");
        municipios.add("Cruzeta");
        municipios.add("Jaçanã");
        municipios.add("Serra Negra do Norte");
        municipios.add("Lagoa Salgada");
        municipios.add("Carnaúba dos Dantas");
        municipios.add("Portalegre");
        municipios.add("Pedro Avelino");
        municipios.add("Riachuelo");
        municipios.add("Lagoa de Pedras");
        municipios.add("Itajá");
        municipios.add("Antônio Martins");
        municipios.add("Jandaíra");
        municipios.add("Serrinha");
        municipios.add("Doutor Severiano");
        municipios.add("Lagoa d'Anta");
        municipios.add("São Pedro");
        municipios.add("São Vicente");
        municipios.add("Caiçara do Norte");
        municipios.add("São João do Sabugi");
        municipios.add("José da Penha");
        municipios.add("Equador");
        municipios.add("Severiano Melo");
        municipios.add("Serra de São Bento");
        municipios.add("Felipe Guerra");
        municipios.add("Senador Elói de Souza");
        municipios.add("Itaú");
        municipios.add("Japi");
        municipios.add("Tenente Laurentino Cruz");
        municipios.add("Coronel Ezequiel");
        municipios.add("Janduís");
        municipios.add("Encanto");
        municipios.add("Várzea");
        municipios.add("Porto do Mangue");
        municipios.add("Bento Fernandes");
        municipios.add("Sítio Novo");
        municipios.add("Almino Afonso");
        municipios.add("Parazinho");
        municipios.add("Coronel João Pessoa");
        municipios.add("Santa Maria");
        municipios.add("Ouro Branco");
        municipios.add("Rafael Fernandes");
        municipios.add("Lajes Pintadas");
        municipios.add("Serrinha dos Pintos");
        municipios.add("Rodolfo Fernandes");
        municipios.add("Olho-d'Água do Borges");
        municipios.add("Frutuoso Gomes");
        municipios.add("São José do Seridó");
        municipios.add("Messias Targino");
        municipios.add("Riacho de Santana");
        municipios.add("Barcelona");
        municipios.add("Paraná");
        municipios.add("Senador Georgino Avelino");
        municipios.add("São Bento do Trairi");
        municipios.add("São Francisco do Oeste");
        municipios.add("Paraú");
        municipios.add("Venha-Ver");
        municipios.add("Tibau");
        municipios.add("Lucrécia");
        municipios.add("Ruy Barbosa");
        municipios.add("Jundiá");
        municipios.add("Major Sales");
        municipios.add("Pedra Grande");
        municipios.add("Pilões");
        municipios.add("São Fernando");
        municipios.add("Triunfo Potiguar");
        municipios.add("Caiçara do Rio do Vento");
        municipios.add("Riacho da Cruz");
        municipios.add("Rafael Godeiro");
        municipios.add("Água Nova");
        municipios.add("São Bento do Norte");
        municipios.add("Passagem");
        municipios.add("Francisco Dantas");
        municipios.add("Vila Flor");
        municipios.add("Fernando Pedroza");
        municipios.add("Lagoa de Velhos");
        municipios.add("Jardim de Angicos");
        municipios.add("João Dias");
        municipios.add("Pedra Preta");
        municipios.add("Santana do Seridó");
        municipios.add("Bodó");
        municipios.add("Taboleiro Grande");
        municipios.add("Timbaúba dos Batistas");
        municipios.add("Monte das Gameleiras");
        municipios.add("Galinhos");
        municipios.add("Ipueira");
        municipios.add("Viçosa");
        return municipios;
    }


    public static ArrayList<String> municipiosPB(){

        ArrayList<String> municipios = new ArrayList<String>();
        municipios.add("João Pessoa");
        municipios.add("Campina Grande");
        municipios.add("Santa Rita");
        municipios.add("Patos");
        municipios.add("Bayeux");
        municipios.add("Sousa");
        municipios.add("Cabedelo");
        municipios.add("Cajazeiras");
        municipios.add("Guarabira");
        municipios.add("Sapé");
        municipios.add("Mamanguape");
        municipios.add("Queimadas");
        municipios.add("São Bento");
        municipios.add("Monteiro");
        municipios.add("Esperança");
        municipios.add("Pombal");
        municipios.add("Catolé do Rocha");
        municipios.add("Alagoa Grande");
        municipios.add("Pedras de Fogo");
        municipios.add("Lagoa Seca");
        municipios.add("Solânea");
        municipios.add("Itaporanga");
        municipios.add("Itabaiana");
        municipios.add("Conde");
        municipios.add("Rio Tinto");
        municipios.add("Princesa Isabel");
        municipios.add("Areia");
        municipios.add("Mari");
        municipios.add("Caaporã");
        municipios.add("Bananeiras");
        municipios.add("Alagoa Nova");
        municipios.add("Cuité");
        municipios.add("Araruna");
        municipios.add("São José de Piranhas");
        municipios.add("Alhandra");
        municipios.add("Remígio");
        municipios.add("Aroeiras");
        municipios.add("Pitimbu");
        municipios.add("Conceição");
        municipios.add("Picuí");
        municipios.add("Itapororoca");
        municipios.add("Pocinhos");
        municipios.add("Ingá");
        municipios.add("Juazeirinho");
        municipios.add("São João do Rio do Peixe");
        municipios.add("Boqueirão");
        municipios.add("Belém");
        municipios.add("Cruz do Espírito Santo");
        municipios.add("Cacimba de Dentro");
        municipios.add("Araçagi");
        municipios.add("Sumé");
        municipios.add("Piancó");
        municipios.add("Coremas");
        municipios.add("Santa Luzia");
        municipios.add("Uiraúna");
        municipios.add("Barra de Santa Rosa");
        municipios.add("Taperoá");
        municipios.add("Teixeira");
        municipios.add("Soledade");
        municipios.add("Tavares");
        municipios.add("Alagoinha");
        municipios.add("Jacaraú");
        municipios.add("Gurinhém");
        municipios.add("Brejo do Cruz");
        municipios.add("Massaranduba");
        municipios.add("Puxinanã");
        municipios.add("Serra Branca");
        municipios.add("Arara");
        municipios.add("Mogeiro");
        municipios.add("Lucena");
        municipios.add("Paulista");
        municipios.add("Salgado de São Félix");
        municipios.add("Pilar");
        municipios.add("Bonito de Santa Fé");
        municipios.add("Imaculada");
        municipios.add("São Sebastião de Lagoa de Roça");
        municipios.add("Fagundes");
        municipios.add("Manaíra");
        municipios.add("São Vicente do Seridó");
        municipios.add("Tacima");
        municipios.add("Itatuba");
        municipios.add("Juripiranga");
        municipios.add("Nova Floresta");
        municipios.add("Pirpirituba");
        municipios.add("Natuba");
        municipios.add("Dona Inês");
        municipios.add("Cachoeira dos Índios");
        municipios.add("Água Branca");
        municipios.add("Umbuzeiro");
        municipios.add("Mulungu");
        municipios.add("Juru");
        municipios.add("Triunfo");
        municipios.add("Baía da Traição");
        municipios.add("Riacho dos Cavalos");
        municipios.add("Marcação");
        municipios.add("Gado Bravo");
        municipios.add("Aparecida");
        municipios.add("Mataraca");
        municipios.add("Desterro");
        municipios.add("Barra de Santana");
        municipios.add("Pedra Lavrada");
        municipios.add("Juarez Távora");
        municipios.add("Sobrado");
        municipios.add("São Mamede");
        municipios.add("Jericó");
        municipios.add("São José da Lagoa Tapada");
        municipios.add("Lagoa de Dentro");
        municipios.add("Casserengue");
        municipios.add("Livramento");
        municipios.add("Belém do Brejo do Cruz");
        municipios.add("Nazarezinho");
        municipios.add("Caiçara");
        municipios.add("Cubati");
        municipios.add("Cacimbas");
        municipios.add("São Miguel de Taipu");
        municipios.add("Junco do Seridó");
        municipios.add("Santana dos Garrotes");
        municipios.add("Serra Redonda");
        municipios.add("Boa Vista");
        municipios.add("Areial");
        municipios.add("Cuitegi");
        municipios.add("Condado");
        municipios.add("Pilões");
        municipios.add("Santa Cruz");
        municipios.add("Olho d'Água");
        municipios.add("Diamante");
        municipios.add("Santa Cecília");
        municipios.add("Marizópolis");
        municipios.add("Matureia");
        municipios.add("Capim");
        municipios.add("Brejo dos Santos");
        municipios.add("Cuité de Mamanguape");
        municipios.add("São José de Caiana");
        municipios.add("Igaracy");
        municipios.add("Serraria");
        municipios.add("Pedro Régis");
        municipios.add("Camalaú");
        municipios.add("Caldas Brandão");
        municipios.add("Nova Olinda");
        municipios.add("Ibiara");
        municipios.add("Barra de São Miguel");
        municipios.add("São José dos Ramos");
        municipios.add("Santa Helena");
        municipios.add("Malta");
        municipios.add("Montadas");
        municipios.add("Aguiar");
        municipios.add("Cabaceiras");
        municipios.add("Alcantil");
        municipios.add("Boa Ventura");
        municipios.add("Borborema");
        municipios.add("Vieirópolis");
        municipios.add("Damião");
        municipios.add("Curral de Cima");
        municipios.add("Santana de Mangueira");
        municipios.add("Pilõezinhos");
        municipios.add("Bom Sucesso");
        municipios.add("Sertãozinho");
        municipios.add("Catingueira");
        municipios.add("Nova Palmeira");
        municipios.add("Baraúna");
        municipios.add("Caturité");
        municipios.add("Monte Horebe");
        municipios.add("Congo");
        municipios.add("Lagoa");
        municipios.add("São José de Espinharas");
        municipios.add("Santa Teresinha");
        municipios.add("Matinhas");
        municipios.add("Riachão do Bacamarte");
        municipios.add("São Bentinho");
        municipios.add("Riachão do Poço");
        municipios.add("São João do Tigre");
        municipios.add("São João do Cariri");
        municipios.add("Logradouro");
        municipios.add("Poço de José de Moura");
        municipios.add("Prata");
        municipios.add("Caraúbas");
        municipios.add("São José do Sabugi");
        municipios.add("Mãe d'Água");
        municipios.add("Salgadinho");
        municipios.add("Olivedos");
        municipios.add("São José de Princesa");
        municipios.add("Assunção");
        municipios.add("Pedra Branca");
        municipios.add("Vista Serrana");
        municipios.add("Poço Dantas");
        municipios.add("Cacimba de Areia");
        municipios.add("São José dos Cordeiros");
        municipios.add("Duas Estradas");
        municipios.add("Santa Inês");
        municipios.add("Riachão");
        municipios.add("São José do Bonfim");
        municipios.add("Sossêgo");
        municipios.add("Emas");
        municipios.add("São Sebastião do Umbuzeiro");
        municipios.add("Gurjão");
        municipios.add("Bernardino Batista");
        municipios.add("São Francisco");
        municipios.add("Cajazeirinhas");
        municipios.add("Serra da Raiz");
        municipios.add("São Domingos");
        municipios.add("Serra Grande");
        municipios.add("Tenório");
        municipios.add("Ouro Velho");
        municipios.add("Frei Martinho");
        municipios.add("Mato Grosso");
        municipios.add("Várzea");
        municipios.add("Lastro");
        municipios.add("Joca Claudino");
        municipios.add("Carrapateira");
        municipios.add("São Domingos do Cariri");
        municipios.add("Bom Jesus");
        municipios.add("Santo André");
        municipios.add("Curral Velho");
        municipios.add("Algodão de Jandaíra");
        municipios.add("Passagem");
        municipios.add("Amparo");
        municipios.add("Zabelê");
        municipios.add("Areia de Baraúnas");
        municipios.add("Riacho de Santo Antônio");
        municipios.add("Quixaba");
        municipios.add("Coxixola");
        municipios.add("São José do Brejo do Cruz");
        municipios.add("Parari");


        return municipios;
    }
}
