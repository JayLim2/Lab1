/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ���������
 * ������� ������(���� ��� �� �������� - ������, �������)
 * ������ ������� ���������� � �������� �� �������� ����� � xml �������
 * ������� �� ������� ����� ���� 2
 * OK - ��� ������, ����� ����������
 * ERROR - ��� ����� �� ���. ����� ��������� ������ � xml ���������� ���� �� ������. 
 * �� ��������� ��� ��� ��������� �����/������������
 * �������
 * ADD_AUTHOR - ����� ������� ���������� ������ � XML. ������ ����� ���������� �� ��������.
 * ADD_BOOK - ����������. ������ ���� ��� ����� ������ id �� ������ ������, � ���� �����������.��� ����� ������ ����� Index. 
 * SET_BOOK - ����� ������� ��������� ������. ����� �������, ���� ����� �� ������������� ���-�� ���,
 * ��� ����� ������������ ��� ��������� � �������� OK. ����� �������� ������.����� ��������� ����������, ����������� ���������� �����.
 * SET_AUTHOR - ����������. ���� ����� �� ��������.���� �� ��� �� ������ set �� ��������.��� �� ������ 
 * REMOVE_BOOK - ���������� SET, ���������� ��� �������� ����� ����� � �����. ������� �� ���� ��� ��������� ��� ����
 * REMOVE_AUTHOR - ���������� 
 * VIEW_BOOKS - ����� OK ��������� ��������������� AuthorContainer. ���� ���.
 * VIEW_AUTHORS - ����������.
 * BYE - ��������� ��� ������ ��������� ������. ������� �� � �������� ������.
 */

@XmlRootElement
@XmlEnum(String.class)
public enum Commands {
    ADD_AUTHOR, ADD_BOOK, SET_AUTHOR, SET_BOOK, REMOVE_BOOK, REMOVE_AUTHOR, VIEW_BOOKS, VIEW_AUTHORS, BYE
}
