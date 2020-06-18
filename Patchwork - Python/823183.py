from graphics import *
    
def main():
    size, list_3_colours = userInputs()
    x0 = 0
    y0 = 0
    drawPatchwork(x0,y0, size, list_3_colours)

def userInputs():
    #blank list to hold the three colour inputs
    list_3_colours = []
    #the loop wont stop unless the user enter to required information
    while True:
        size = input("Please enter the correct size (5x5,7x7,9x9): ")
        if size in ["5x5", "7x7", "9x9"]:
            break
        else:
            print("WRONG FORMAT PLEASE RE-ENTER THE SIZE AGAGIN!")
    #ask user three times for the colour inputs and if the user enter colour that is not in the colour
    #it will display error message and ask the user again (loop)
    for i in range(3):
        while True:
            colour = input("Please enter the correct colour: ")
            if colour in ["red","blue", "green", "orange", "pink", "brown"]:
                #add the colours (element) to the list
                list_3_colours.append(colour)
                break
            else:
                print("wrong colour")
    #return size for the patch and a list which contains the three colours
    return eval(size[0]), list_3_colours
def drawPatchwork(x0,y0, size, list_3_colours):
    win = GraphWin("PatchWork", size*100, size*100)
    win.setBackground("white")
    rowvalue = 0
    columnvalue = 0
    drawingPatchWork = True
    while drawingPatchWork == True:
        #row = column
        #column = row
        #keep drawing until rowvalue reaches the patchwork size
        if rowvalue == size:
            drawingPatchWork = False
        #if the columnvalue reaches the patchwork size, it stop and continue on the next row
        elif columnvalue == size:
            # + x value by 100 and reset y value back to 0
            x0+=100
            y0=0
            rowvalue+=1
            columnvalue=0
        else:
            #draw fpatch on the bottom column 
            if columnvalue == size -1 and rowvalue%2 == 0:
                if rowvalue == 0:
                    #colour 2
                    drawPatchF(win, x0, y0, list_3_colours[1])
                    y0+=100
                    columnvalue+=1
                else:
                    #colour 3
                    drawPatchF(win, x0, y0, list_3_colours[2])
                    y0+=100
                    columnvalue+=1
            #draw fpatch on the the last row
            elif rowvalue == size-1:
                #the first column is colour 2
                if columnvalue == 0:
                    drawPatchF(win, x0, y0, list_3_colours[1])
                    y0+=100
                    columnvalue+=1
                #rest of the column is colour 3 
                else:
                    drawPatchF(win, x0, y0, list_3_colours[2])
                    y0+=100
                    columnvalue+=1
            else:
                #draw fpatch once every 2 middle rows in colour2 (restrict the range to draw the patch)
                if rowvalue + columnvalue > size -2 and rowvalue%2 ==0:
                    if rowvalue+columnvalue == size -1:
                        drawPatchF(win, x0, y0, list_3_colours[1])
                        y0+=100
                        columnvalue+=1
                    else:
                        #draw same patch but in different colour on the same row but to end of the column
                        drawPatchF(win, x0, y0, list_3_colours[2])
                        y0+=100
                        columnvalue+=1
                #draw p patch in the middle in colour 2
                elif rowvalue + columnvalue == size-1:
                    drawPatchP(win, x0, y0, list_3_colours[1])
                    y0+=100
                    columnvalue+=1
                else:
                    #draw p patch at the bottom and bottom right in colour 3
                    if rowvalue+columnvalue > size -2 and rowvalue%2 ==1:
                        drawPatchP(win, x0, y0, list_3_colours[2])
                        y0+=100
                        columnvalue+=1
                    else:
                        #filled the rest of the patchwork with p patch in colour 1
                        drawPatchP(win, x0, y0, list_3_colours[0])
                        y0+=100
                        columnvalue+=1

def drawPatchF(win, x0, y0, colour):

    for i in range(10):
        p1 = Point(x0+i*10,y0)
        p2 = Point(x0+100 - i*10, y0+100)
        p3 = Point(x0, y0+100 - i*10)
        p4 = Point(x0+100, y0 + i*10)
        
        fline = Line(p1, p2)
        fline.setOutline(colour)
        fline.draw(win)
        
        Sline = Line(p3, p4)
        Sline.setOutline(colour)
        Sline.draw(win)

def drawPatchP(win, x0, y0, colour):
    #set rows and columns to 0
    row = 0
    column = 0
    #colour 0 will be your colour input and 1 will be white
    nextColour = 0
    #newY is the value for the column to reset Y and add on another 20
    newY = y0
    newX = x0
    for columns in range(5):
        for rows in range(5):
            for rectangles in range(4):
                #if nextColour is 0 draw coloured rectangle
                if nextColour == 0:
                    rectangle = Rectangle(Point(x0,y0),Point(x0+5,y0+20))
                    rectangle.draw(win)
                    rectangle.setFill(colour)
                    x0 += 5
                #if nextColour is 1 draw a white rectangle
                else: 
                    rectangle = Rectangle(Point(x0,y0),Point(x0+20,y0+5))
                    rectangle.draw(win)
                    rectangle.setFill("white")
                    y0 += 5
            
            #if nextColour is coloured then next colour will be white
            if nextColour == 0:
                nextColour = 1
            #reverse if colour is white
            else:
                nextColour = 0
                #since Y ends at the bottom and x is not changed, add 20 and reset Y
                x0 += 20
                y0 = newY
        
        #makes next column white if column%2 is 1
        if column%2 == 1:
            nextColour = 1
        
        #reset x for next colomn
        x0 = newX
       
        newY += 20
        #set Y to the newY to repeat the drawings on that row
        y0 = newY



main()














