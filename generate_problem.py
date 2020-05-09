import os
import urllib.request, json
from random import randint
from datetime import date
import math

def getSolvedCount(index, data):
    if data['result']['problemStatistics'][index]['solvedCount']:
        return data['result']['problemStatistics'][index]['solvedCount']
    return 0

def solvedCount(elem):
    return elem['solvedCount']

def getData(url):
    response = urllib.request.urlopen(url)
    return json.loads(response.read().decode())

def getProblems():
    data = getData('https://codeforces.com/api/problemset.problems')
    for i in range(len(data['result']['problems'])):
        data['result']['problems'][i]['solvedCount'] = getSolvedCount(i, data)
    return data['result']['problems']

def getAcceptedProblems(user):
    page = 0
    count = 100
    dictionaryProblems = {}
    data = getData('https://codeforces.com/api/user.status?handle='+user+'&from='+str(page*count+1)+'&count='+str(count))
    while len(data['result']) > 0:
        for i in range(len(data['result'])):
            if data['result'][i]['verdict'] == 'OK':
                if data['result'][i]['problem']['contestId'] in dictionaryProblems:
                    dictionaryProblems[data['result'][i]['problem']['contestId']].update({data['result'][i]['problem']['index']: {}})
                else:
                    dictionaryProblems.update({data['result'][i]['problem']['contestId']: {data['result'][i]['problem']['index']: {}}})
        page += 1
        data = getData('https://codeforces.com/api/user.status?handle='+user+'&from='+str(page*count+1)+'&count='+str(count))
    return dictionaryProblems

def getListAcceptedProblems(problems, dictAcceptedProblems):
    acceptedProblems = []
    for problem in problems:
        if (problem['contestId'] in dictAcceptedProblems) and (problem['index'] in dictAcceptedProblems[problem['contestId']]):
            acceptedProblems.append(problem)
    return acceptedProblems

def getProbablyProblems(problems, dictAcceptedProblems, min, max):
    probablyProblems = []
    for problem in problems:
        #if (problem['solvedCount'] >= min) and (problem['solvedCount'] <= max) and ((problem['contestId'] not in dictAcceptedProblems) or (problem['index'] not in dictAcceptedProblems[problem['contestId']])):
        if ('rating' in problem and problem['rating'] >= min) and (problem['rating'] <= max) and ((problem['contestId'] not in dictAcceptedProblems) or (problem['index'] not in dictAcceptedProblems[problem['contestId']])):
            probablyProblems.append(problem)
    return probablyProblems

def generateFile(contestId, index, problemUrl):
    MYDIR = os.path.join(os.path.dirname(__file__), 'python3')
    readF = open(MYDIR + '/template.py', 'r')
    url = MYDIR + '/CF' + str(contestId) + index + '.py'
    readW = open(os.path.join(MYDIR, 'CF' + str(contestId) + index + '.py'), "w+")
    lines = readF.read().splitlines()
    for line in lines:
        readW.write(line + ' ')
        if 'url' in line:
            readW.write(problemUrl)
        elif 'date' in line:
            readW.write(date.today().strftime("%d/%m/%Y"))
        readW.write('\n')
    readF.close()
    readW.close()
    return url

user = 'egaeus.code'
problems = getProblems()
problems = sorted(problems, key = solvedCount)
dictAcceptedProblems = getAcceptedProblems(user)
acceptedProblems = getListAcceptedProblems(problems, dictAcceptedProblems)
#medianProblem = acceptedProblems[int(math.floor(len(acceptedProblems)/3))]
#delta = min(medianProblem['solvedCount']/10, 1000)
#probablyProblems = getProbablyProblems(problems, dictAcceptedProblems, medianProblem['solvedCount'] - delta, medianProblem['solvedCount'])
probablyProblems = getProbablyProblems(problems, dictAcceptedProblems, 1800, 2200)
selectedProblem = probablyProblems[randint(0, len(probablyProblems) - 1)]
url = 'https://codeforces.com/problemset/problem/'+str(selectedProblem['contestId'])+'/'+selectedProblem['index']
print (url)
#print (generateFile(selectedProblem['contestId'], selectedProblem['index'], url))
print ('rating: ', selectedProblem['rating'], 'solvedCount: ', selectedProblem['solvedCount'])
