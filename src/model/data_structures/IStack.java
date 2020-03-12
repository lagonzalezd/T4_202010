package model.data_structures;

public interface IStack<Item> {

	public boolean isEmpty();

	public int size();

	public Item pop();

	public Item peek();
}
