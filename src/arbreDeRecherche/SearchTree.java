
package arbreDeRecherche;
/**
 * Classe utilitaire pour la représentation et la manipulation d'un "arbre de recherche"
 * (ou "arbre binaire ordonné").
 * Implémentation purement dynamique adaptée aux traitements récursifs.
 * L'équilibrage des arbres n'est pas pris en compte ici.
 * 
 * @author Erick Timmerman <Erick.Timmerman@univ-lille.fr>
 * @param <E> type des éléments de l'arbre, ce type doit être "Comparable".
 */
public class SearchTree<E extends Comparable<E>>
{
    private class Node<T extends Comparable<T>>
    {
        T value;
        SearchTree<T> left;
        SearchTree<T> right;

        Node(T value) 	// création d'un noeud isolé.
        {
            this.value = value;
            this.left  = new SearchTree<>();
            this.right = new SearchTree<>();
        }
        Node(T value, SearchTree<T> left, SearchTree<T> right)
        {
            this.value = value;
            this.left  = left;
            this.right = right;
        }
    }  // fin de la classe interne "Node"
    
    private Node<E> root;                 // seul attribut de la classe SearchTree

    public SearchTree()                   // construction d'un arbre vide
    {
        root = null;
    }

    public SearchTree(E valeur)          // construction d'un arbre feuille
    {
        root = new Node<>(valeur);
    }

    public boolean estVide()
    {
        return root == null;
    }

    public E racine()
    {
        return root.value;
    }

    public SearchTree<E> gauche()
    {
        return root.left;
    }

    public SearchTree<E> droit()
    {
        return root.right;
    }

    private void setRacine(E val)
    {
        root.value = val;
    }

    private void setTree(SearchTree<E> tree)
    {
        root = tree.root;
    }

// On peut dès à présent oublier la classe interne Node!
    public boolean estUneFeuille()
    {
        return gauche().estVide() && droit().estVide();
    }

    /** 
     * Calcule l'expression de type "fonctionnelle" correspondant à l'arbre.
     * @return une représentation littérale des valeurs de l'arbre.
     */
    @Override
    public String toString() // 
    {
        if (estVide())
            return "";
        if (estUneFeuille())
            return "" + racine();
        return racine() + "(" + gauche() + "," + droit() + ")";
    }

    /** 
     * Calcule la suite "infixe" des valeurs de l'arbre.
     * Cette suite est naturellement ordonnée (croissante) si l'arbre est
     * effectivement un arbre de recherche.
     * @return la chaîne de caractères, suite infixe des valeurs de l'arbre.
     */
    public String infixe() 		// suite infixe ou GRD
    {
        if (estVide())
            return "";
        return gauche().infixe() + racine() + " " + droit().infixe();
    }
    
    /**    
     * Détermine si l'arbre contient la valeur fournie.
     * @param val la valeur recherchée
     * @return vrai ssi la valeur val est présente dans l'arbre.
     */
    public boolean contient(E val)
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** 
     * Insère la valeur fournie dans l'arbre.
     * @param val la valeur à insérer dans l'arbre.
     */
    public void inserer(E val)
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**  
     * Supprime de l'arbre une occurrence de la valeur fournie.
     * @param val la valeur à supprimer de l'arbre.
     */
    public void supprimer(E val)
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** 
     * Détermine si l'arbre (this) est effectivement un arbre de recherche.
     * @return vrai ssi l'arbre est réellement un arbre de recherche.
     */
    public boolean isValid()
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Construit un arbre de recherche équilibré comportant toutes les valeurs
     * apparaissant dans un vecteur ordonné fourni.
     * Ce vecteur doit être ordonné (ordre croissant) aucune vérification n'est faite ici.
     * @param elements vecteur ordonné contenant les valeurs à placer dans l'arbre.
     */
    public SearchTree(E[] elements)
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* constructeur utilitaire interne privé.
       les arbres fournis sont des arbres de recherche,
       la valeur fournie est >= la plus grande des valeurs de l'arbre gauche
                          et <= la plus petite des valeurs de l'arbre droit.
    */
    private SearchTree(E valeur, SearchTree<E> gauche, SearchTree<E> droit)
    {
        root = new Node<>(valeur, gauche, droit);
    }

}
