/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ���������
 * ������ ������� �� �������
 * ���� ������ OK � ERROR
 * �� ������� ������� ������ ������. ����� ��� ���������� ����������.
 */
@XmlRootElement
@XmlEnum(String.class)
public enum Responses {
    OK,ERROR
}
