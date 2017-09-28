package br.com.alosilla.automanager.util;

import java.io.Serializable;

/**
 *
 * @author JORGE
 */
public interface AbstractEntityId<T> extends Serializable{

    public T getId();
}
