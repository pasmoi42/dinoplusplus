import copy
import random

MORT = 0
VIVANT = 1
LARGC = 10
MORT_COUL = (0,0,0)
VIVANT_COUL = (1,1,1)

ETATS = [MORT,VIVANT]


def afficher_txt (m) :
    for i in m :
        print (i)

def gen_alea (larg, haut) :
    m = []
    for i in range (0,haut) :
        m.append([])
        for j in range (0,larg) :
            m[i].append(random.randint(0,1))
    return m
"""
def parser (nom_fic) :
    grille = []
    with open(nom_fic) as f:
        for ligne in f:
            ligne_cell = []
            #on enleve les espaces
            for car in ligne.rstrip():
                etat = int(car)
                if etat in ETATS :
                    ligne_cell.append(etat)
            grille.append(ligne_cell)
    return grille
"""
def photo_gfx (m,fichier) :
    p = plot(0)
    for i in range(0,len(m)) :
        for j in range(0,len(m[i])) :
            if m[i][j] == MORT :
                coul = MORT_COUL
            if m[i][j] == VIVANT :
                coul = VIVANT_COUL
            p += polygon2d([[j*LARGC,-i*LARGC],\
                            [j*LARGC,-(i+1)*LARGC],\
                            [(j+1)*LARGC,-(i+1)*LARGC],\
                            [(j+1)*LARGC,-i*LARGC]],rgbcolor = coul)
    #p.show()
    p.save(fichier)

def photo_pbm (m,fichier) :
    f = open(fichier, "w")
    f.write("P1\n" + str(len(m[0])) + " " + str(len(m)) + "\n")
    for i in range(0, len(m)) :
    	for j in range (0, len(m[i])) :
	## pas plus de 70 caracteres par ligne
	    if ((i*j)%30 == 0) :
	       f.write("\n");
	    f.write (str(m[i][j]) + " ")
    f.write("\n")
    f.close()

"""
def peupler () :
    m = [[1,2,1,2,1,0,0,0,1,0],[1,2,1,2,1,1,1,1,2,2],[1,2,1,2,1,1,1,1,1,2],[1,2,1,2,1,1,2,2,2,2],[1,2,1,2,1,1,1,1,2,2],\
         [2,1,1,1,2,0,0,0,1,0],[2,1,1,1,2,1,1,1,2,2],[2,1,1,1,2,1,1,1,1,2],[2,1,1,1,2,1,2,2,2,2],[2,1,1,1,2,1,1,1,2,2]]
    return m
"""

def iter (m) :
    nouv_m = copy.deepcopy(m)
    for i in range(0,len(m)):
        for j in range(0, len(m[i])):
            nouv_m[i][j] = maj (m, j, i)
            #print str(m[i][j]) +" DEVENU " + str(nouv_m[i][j])
    return nouv_m

def maj (m,x,y) :
    nb_mort = 0
    nb_vivant = 0
    for i in range (max(0,y-1), min(len(m),y+2)):
        for j in range (max(0,x-1), min(len(m[i]),x+2)):
	    if ((i == y) and (j == x)) : continue
	    if (m[i][j] == MORT) : nb_mort +=1
	    if (m[i][j] == VIVANT) : nb_vivant +=1
    if (nb_vivant == 3) : 
	return VIVANT
    elif (m[y][x] == MORT) and (nb_vivant == 2) :
	return MORT
    elif (m[y][x] == VIVANT) and (nb_vivant == 2) :
	return VIVANT
    elif (nb_vivant < 2 or nb_vivant > 3) : 
	return MORT
    return m[y][x]


if len(sys.argv) != 4 :
    print "3 arguments attendus : \n\
1 - largeur\n\
2 - hauteur\n\
3 - nombre d'images \n"
    sys.exit()

m = gen_alea (int(sys.argv[1]), int(sys.argv[2]))
afficher_txt (m)
photo_pbm (m, "photo0.png")
for i in range (1,int(sys.argv[3])) :
    m = iter(m)
    print "Generation photo " + str(i)
    photo_pbm (m, "photo" + str(i) + ".png")
