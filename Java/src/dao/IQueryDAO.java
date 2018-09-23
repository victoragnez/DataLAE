/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.Area;
import service.Pesquisa;
import service.Viagem;

import java.util.ArrayList;

public interface IQueryDAO {
	public ArrayList<Pesquisa> queryPesquisas();
	public ArrayList<Area> queryArea(Pesquisa p);
	public ArrayList<Viagem> queryViagem(Area a);
}
